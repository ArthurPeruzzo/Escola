package arthur.com.example.escola.Aluno.Controller;

import arthur.com.example.escola.Aluno.Aluno;
import arthur.com.example.escola.Aluno.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> buscarTodosAlunos(){
       return alunoService.buscarTodos();
    }

    @GetMapping(value = "/{matricula}")// o {matricula} faz com que possa colocar uma matricula na url;
    public Aluno buscarPorMatricula(@PathVariable Long matricula){
        return alunoService.buscarPorMatricula(matricula);
    }
    @ResponseStatus(HttpStatus.CREATED) //codigo 201
    @PostMapping
    public void inserirAluno(@RequestBody  Aluno aluno){ //com o ResquestBody, o aluno passado é convertido para objeto
         alunoService.inserirAluno(aluno);
    }

    @DeleteMapping(value = "/{matricula}")
    public void deletarAluno(@PathVariable Long matricula){
        alunoService.deletarAluno(matricula);
    }

    @PutMapping(value = "/{matricula}")
    public Aluno atualizarAluno(@RequestBody Aluno aluno, @PathVariable Long matricula){
        return alunoService.atualizarAluno(matricula, aluno);
    }
}
