package arthur.com.example.escola.Presenca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresencaService {

    @Autowired
    private PresencaRepository presencaRepository;

   public List<Presenca> buscarTodasAsPresencas(){
        return presencaRepository.findAll();
    }

   public Presenca buscarPresencaPorId(Long id){
       Optional<Presenca> presenca = presencaRepository.findById(id);
       return presenca.get();
   }


   public void inserirPresenca(Presenca presenca){
       presencaRepository.save(presenca);
   }

   public void deletarPresenca(Long id){
       presencaRepository.deleteById(id);
   }
}
