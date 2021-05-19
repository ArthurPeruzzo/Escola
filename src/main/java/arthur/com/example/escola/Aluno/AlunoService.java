package arthur.com.example.escola.Aluno;

import arthur.com.example.escola.Excecoes.DatabaseException;
import arthur.com.example.escola.Excecoes.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

   public List<Aluno> buscarTodos(){
        return alunoRepository.findAll();
    }

    public Aluno buscarPorMatricula( Long matricula){
         Optional<Aluno> aluno = alunoRepository.findById(matricula);
         return aluno.orElseThrow(()-> new ResourceNotFoundException(matricula));
    }

    public void inserirAluno(Aluno aluno){
       alunoRepository.save(aluno);
    }

    public void deletarAluno(Long matricula){
       try{
           alunoRepository.deleteById(matricula);
       }catch (EmptyResultDataAccessException e){
           throw new ResourceNotFoundException(matricula);
       }catch (DataIntegrityViolationException e){
           throw new DatabaseException(e.getMessage());
       }

    }

    public Aluno atualizarAluno(Long matricula, Aluno aluno){
       Aluno entidade = alunoRepository.getOne(matricula);  //deixa o usuario preparado para ser manipulado, sem ir no banco de dados
        atualizarDadosAluno(aluno,entidade);
        return alunoRepository.save(entidade);
   }
    public void atualizarDadosAluno(Aluno aluno, Aluno entidade){
      entidade.setNome(aluno.getNome());
      entidade.setEmail(aluno.getEmail());
      entidade.setTelefone(aluno.getTelefone());
    }
}
