package arthur.com.example.escola.Aluno.Repository;

import arthur.com.example.escola.Aluno.Entidade.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
