package arthur.com.example.escola.Presenca;

import arthur.com.example.escola.Aluno.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/presencas")
public class PresencaController {

    @Autowired
    private PresencaService presencaService;

    @GetMapping
    public List<Presenca> buscarTodasAsPresencas(){
        return presencaService.buscarTodasAsPresencas();
    }

    @GetMapping(value = "/{id}")
    public Presenca buscarPresencaPorId(@PathVariable Long id){
        return presencaService.buscarPresencaPorId(id);
    }

    @ResponseStatus(HttpStatus.CREATED) //codigo 201
    @PostMapping
    public void inserirPresenca(@RequestBody Presenca presenca){ //com o ResquestBody, o aluno passado é convertido para objeto
        presencaService.inserirPresenca(presenca);
    }

    @DeleteMapping(value = "/{id}")
    public void deletarPresenca(@PathVariable Long id){
        presencaService.deletarPresenca(id);
    }


}
