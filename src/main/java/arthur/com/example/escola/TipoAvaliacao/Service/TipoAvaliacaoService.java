package arthur.com.example.escola.TipoAvaliacao.Service;

import arthur.com.example.escola.TipoAvaliacao.Repository.TipoAvaliacaoRepository;
import arthur.com.example.escola.TipoAvaliacao.Entidade.TipoAvaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoAvaliacaoService {

    @Autowired
    private TipoAvaliacaoRepository tipoAvaliacaoRepository;

    public List<TipoAvaliacao> buscarTodos(){
        return tipoAvaliacaoRepository.findAll();
    }

    public TipoAvaliacao buscarPorId( Long id){
        Optional<TipoAvaliacao> tipoAvaliacao = tipoAvaliacaoRepository.findById(id);
        return tipoAvaliacao.get();
    }

}
