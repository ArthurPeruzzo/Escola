package arthur.com.example.escola.Bimestre;

import arthur.com.example.escola.Avaliacao.Avaliacao;
import arthur.com.example.escola.Enums.BimestreEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_bimestre")
public class Bimestre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BimestreEnum bimestre;
    private LocalDate inicioBimestre;
    private LocalDate fimBimestre;

    @JsonIgnore
    @OneToMany(mappedBy = "bimestre")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Bimestre(){
    }

    public Bimestre(Long id, BimestreEnum bimestre, LocalDate inicioBimestre, LocalDate fimBimestre) {
        this.id = id;
        this.bimestre = bimestre;
        this.inicioBimestre = inicioBimestre;
        this.fimBimestre = fimBimestre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BimestreEnum getBimestre() {
        return bimestre;
    }

    public void setBimestre(BimestreEnum bimestre) {
        this.bimestre = bimestre;
    }

    public LocalDate getInicioBimestre() {
        return inicioBimestre;
    }

    public void setInicioBimestre(LocalDate inicioBimestre) {
        this.inicioBimestre = inicioBimestre;
    }

    public LocalDate getFimBimestre() {
        return fimBimestre;
    }

    public void setFimBimestre(LocalDate fimBimestre) {
        this.fimBimestre = fimBimestre;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bimestre bimestre = (Bimestre) o;
        return id.equals(bimestre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
