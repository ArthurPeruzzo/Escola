package arthur.com.example.escola.Bimestre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bimestres")
public class BimestreController {

    @Autowired
    private BimestreService bimestreService;

    @GetMapping
    public List<Bimestre> buscarTodosBimestres(){
        return bimestreService.buscarTodosBimestre();
    }
    @GetMapping(value = "/{id}")
    public Bimestre buscarBimestre(@PathVariable Long id){
        return bimestreService.buscarBimestrePorId(id);
    }

}
