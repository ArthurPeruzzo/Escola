package arthur.com.example.escola.Avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public List<Avaliacao> buscarTodasAvaliacoes(){
        return avaliacaoService.buscarTodasAvaliacoes();
    }

    @GetMapping(value = "/{id}")
    public Avaliacao buscarAvPorId(@PathVariable Long id){
        return avaliacaoService.buscarPorId(id);
    }

    @PutMapping(value = "{/id}")
    public Avaliacao atualizarNota(@PathVariable Long id, @RequestBody Avaliacao avaliacao){
        return avaliacaoService.atualizarNota(id, avaliacao);
    }


}
