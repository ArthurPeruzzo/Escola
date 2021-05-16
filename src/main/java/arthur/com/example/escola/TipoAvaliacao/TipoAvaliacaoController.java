package arthur.com.example.escola.TipoAvaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tipoAvaliacao")
public class TipoAvaliacaoController {

    @Autowired
    private TipoAvaliacaoService tipoAvaliacaoService;

    @GetMapping
    public List<TipoAvaliacao> buscarTodosOsTipoAv(){
        return tipoAvaliacaoService.buscarTodos();
    }

    @GetMapping(value = "/{id}")
    public TipoAvaliacao buscarPorId(@PathVariable Long id){
        return tipoAvaliacaoService.buscarPorId(id);
    }
}
