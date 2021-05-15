package arthur.com.example.escola.TipoAvaliacao.Entidade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "tb_TipoAvaliacao")
public class TipoAvaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeAvaliacao;
    private Double pesoAvaliacao;

    public TipoAvaliacao(){
    }

    public TipoAvaliacao(Long id, String nomeAvaliacao, Double pesoAvaliacao) {
        this.id = id;
        this.nomeAvaliacao = nomeAvaliacao;
        this.pesoAvaliacao = pesoAvaliacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAvaliacao() {
        return nomeAvaliacao;
    }

    public void setNomeAvaliacao(String nomeAvaliacao) {
        this.nomeAvaliacao = nomeAvaliacao;
    }

    public Double getPesoAvaliacao() {
        return pesoAvaliacao;
    }

    public void setPesoAvaliacao(Double pesoAvaliacao) {
        this.pesoAvaliacao = pesoAvaliacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoAvaliacao that = (TipoAvaliacao) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
