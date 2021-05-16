package arthur.com.example.escola.Bimestre.Repository;

import arthur.com.example.escola.Bimestre.Entidade.Bimestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BimestreRepository extends JpaRepository<Bimestre, Long> {
}
