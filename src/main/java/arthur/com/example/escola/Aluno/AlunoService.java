package arthur.com.example.escola.Aluno;

import arthur.com.example.escola.Aluno.Aluno;
import arthur.com.example.escola.Aluno.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
         return aluno.get();
    }

    public void inserirAluno(Aluno aluno){
       alunoRepository.save(aluno);
    }

    public void deletarAluno(Long matricula){
       alunoRepository.deleteById(matricula);
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
