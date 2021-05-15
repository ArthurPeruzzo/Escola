package arthur.com.example.escola.Configuracao;

import arthur.com.example.escola.Aluno.Entidade.Aluno;
import arthur.com.example.escola.Aluno.Repository.AlunoRepository;
import arthur.com.example.escola.Avaliacao.Entidade.Avaliacao;
import arthur.com.example.escola.Avaliacao.Repository.AvaliacaoRepository;
import arthur.com.example.escola.TipoAvaliacao.Entidade.TipoAvaliacao;
import arthur.com.example.escola.TipoAvaliacao.Repository.TipoAvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration //fala que essa classe é especifica para configuração
@Profile("test") //especifica para o perfil de teste
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository; //injecao de dependencia

    @Autowired
    private TipoAvaliacaoRepository tipoAvaliacaoRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Override
    public void run(String... args) throws Exception {//irá executar o método run assim que o programa for executado


        //adicionando alunos ao banco de dados

        Aluno Pedro = new Aluno(99332737L, "Pedro", "pedro@gmail.com", "99257629");
        Aluno Maria = new Aluno(66887734L, "Maria", "maria@gmail.com", "98274531");
        Aluno Jose = new Aluno(22553434L, "Jose", "jose@gmail.com", "99453762");
        alunoRepository.saveAll(Arrays.asList(Pedro, Maria, Jose));

        //adicionando tipoAvaliacao ao banco de dados

        TipoAvaliacao partSalaDeAula = new TipoAvaliacao(null, "Participação em sala de aula", 1.5);
        TipoAvaliacao entregaDasTarefas = new TipoAvaliacao(null, "Entrega das tarefas", 2.5);
        TipoAvaliacao trabalhoBimestral = new TipoAvaliacao(null, "Trabalho bimestral", 3.0);
        TipoAvaliacao provaBimestral = new TipoAvaliacao(null, "Prova bimestral", 3.0);
        tipoAvaliacaoRepository.saveAll(Arrays.asList(partSalaDeAula, entregaDasTarefas, trabalhoBimestral, provaBimestral));

        //adicionando Avaliacao no banco de dados

        Avaliacao avaliacao1 = new Avaliacao(null, 6.0, partSalaDeAula);
        Avaliacao avaliacao2 = new Avaliacao(null, 7.5, entregaDasTarefas);
        Avaliacao avaliacao3 = new Avaliacao(null, 9.0, trabalhoBimestral);
        Avaliacao avaliacao4 = new Avaliacao(null, 8.0, provaBimestral);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1, avaliacao2, avaliacao3, avaliacao4));




    }

}
