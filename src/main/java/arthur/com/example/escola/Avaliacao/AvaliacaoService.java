package arthur.com.example.escola.Avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> buscarTodasAvaliacoes(){
        return avaliacaoRepository.findAll();
    }

    public Avaliacao buscarPorId(Long id){
        Optional<Avaliacao> av = avaliacaoRepository.findById(id);
        return av.get();
    }

    public Avaliacao atualizarNota(Long id, Avaliacao avaliacao){
        Avaliacao entidade = avaliacaoRepository.getOne(id);  //deixa a avaliacao preparada para ser manipulada, sem ir no banco de dados
        atualizarNotaAvaliacao(avaliacao,entidade);
        return avaliacaoRepository.save(entidade);
    }
    public void atualizarNotaAvaliacao(Avaliacao avaliacao, Avaliacao entidade){
        entidade.setNotaAvaliacao(avaliacao.getNotaAvaliacao());
    }




}
