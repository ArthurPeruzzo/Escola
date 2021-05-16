package arthur.com.example.escola.Aluno;

import arthur.com.example.escola.Avaliacao.Avaliacao;
import arthur.com.example.escola.Bimestre.Bimestre;
import arthur.com.example.escola.Bimestre.NotaBimestre;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable {
    @Id
    private Long matricula;
    private String nome;
    private String email;
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Aluno(){
    }

    public Aluno(Long matricula, String nome, String email, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public List<NotaBimestre> getMediaAlunoPorBimestre(){
        List<NotaBimestre> returnNotas = new ArrayList<>();
        Map<Bimestre, List<Avaliacao>> agrupados = agrupar(avaliacoes);

        for(Map.Entry<Bimestre, List<Avaliacao>> valores : agrupados.entrySet()){ //entrySet cria um conjunto dos mesmos elementos contidos no mapa hash

            Bimestre bimestreAtual = valores.getKey(); //pega a chave de 1 campo da tabela hash
            List<Avaliacao> avaliacoesPorBimestre = valores.getValue(); //pega todos os valores de 1 chave da tabela hash

            double media = 0.0;
            double somaPesos = 0.0;

            for(Avaliacao a : avaliacoesPorBimestre){//soma dos pesos por cada avaliação
                somaPesos += a.getTipoAvaliacao().getPesoAvaliacao();
            }

            double mediaBimestre=0.0;
            for(Avaliacao a : avaliacoesPorBimestre){ //media por bimestre
                media += (a.getNotaAvaliacao() * (a.getTipoAvaliacao().getPesoAvaliacao()));
            }

            mediaBimestre = media/somaPesos;
            NotaBimestre notaBimestre = new NotaBimestre(bimestreAtual, mediaBimestre);
            returnNotas.add(notaBimestre);
        }

        return returnNotas;
    }

    public Map<Bimestre, List<Avaliacao>> agrupar(List<Avaliacao> avaliacaos) {
        Map<Bimestre, List<Avaliacao>> agrupados = new HashMap<>();

        for(Avaliacao avaliacao: avaliacoes){
            Bimestre bimestreAtual = avaliacao.getBimestre();
            if (!agrupados.containsKey(bimestreAtual)) { //se a tabela hash ainda não tiver um bimestre, ela insere
                List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
                avaliacoes.add(avaliacao);
                agrupados.put(bimestreAtual, avaliacoes); //adicionar na tabela hash a avaliacao respectiva ao bimestre
            } else {
                List<Avaliacao> avaliacoesPassadas = agrupados.get(bimestreAtual); //pega o bismestre atual
                avaliacoesPassadas.add(avaliacao);
            }
        }

        return agrupados;
    }
    public double getMediaFinal(){
        double mediaFinal = 0.0;
        for(NotaBimestre media : getMediaAlunoPorBimestre()){
            mediaFinal += media.getNota();
        }
        return mediaFinal/4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return matricula.equals(aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
