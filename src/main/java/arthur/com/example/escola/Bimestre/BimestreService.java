package arthur.com.example.escola.Bimestre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BimestreService {

    @Autowired
    private BimestreRepository bimestreRepository;

    public List<Bimestre> buscarTodosBimestre(){
        return bimestreRepository.findAll();
    }

    public Bimestre buscarBimestrePorId(Long id){
        Optional<Bimestre> bimestre = bimestreRepository.findById(id);
        return bimestre.get();
    }

}
