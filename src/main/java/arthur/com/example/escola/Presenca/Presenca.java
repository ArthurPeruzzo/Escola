package arthur.com.example.escola.Presenca;

import arthur.com.example.escola.Bimestre.Bimestre;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_presenca")
public class Presenca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeroDeFaltas;

    @ManyToOne
    @JoinColumn(name = "id_bimestre") //nome da chave estrangeira
    private Bimestre bimestre;

    public Presenca() {
    }

    public Presenca(Integer numeroDeFaltas, Bimestre bimestre) {
        this.bimestre = bimestre;
        this.numeroDeFaltas = numeroDeFaltas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroDeFaltas() {
        return numeroDeFaltas;
    }

    public void setNumeroDeFaltas(Integer numeroDeFaltas) {
        this.numeroDeFaltas = numeroDeFaltas;
    }

    public Bimestre getBimestre() {
        return bimestre;
    }

    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Presenca presenca = (Presenca) o;
        return id.equals(presenca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
