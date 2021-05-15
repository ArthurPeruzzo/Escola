package arthur.com.example.escola.Avaliacao.Entidade;

import arthur.com.example.escola.TipoAvaliacao.Entidade.TipoAvaliacao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_Avaliacao")
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double notaAvaliacao;

    @ManyToOne
    @JoinColumn(name = "tipoAvaliacao_id") //nome da chave estrangeira
    private TipoAvaliacao tipoAvaliacao;

    public Avaliacao(){
    }

    public Avaliacao(Long id, Double notaAvaliacao, TipoAvaliacao tipoAvaliacao) {
        this.id = id;
        this.notaAvaliacao = notaAvaliacao;
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(Double notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return id.equals(avaliacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
