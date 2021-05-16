package arthur.com.example.escola.Configuracao;

import arthur.com.example.escola.Aluno.Aluno;
import arthur.com.example.escola.Aluno.AlunoRepository;
import arthur.com.example.escola.Avaliacao.Avaliacao;
import arthur.com.example.escola.Avaliacao.AvaliacaoRepository;
import arthur.com.example.escola.Bimestre.Bimestre;
import arthur.com.example.escola.Bimestre.BimestreRepository;
import arthur.com.example.escola.Enums.BimestreEnum;
import arthur.com.example.escola.TipoAvaliacao.TipoAvaliacao;
import arthur.com.example.escola.TipoAvaliacao.TipoAvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
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

    @Autowired
    private BimestreRepository bimestreRepository;

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

        //adcionando Bimestre ao bando de dados
        Bimestre bimestre1 = new Bimestre(null, BimestreEnum.BIMESTRE_1, LocalDate.of(2020, 2, 4), LocalDate.of(2020, 4, 7));
        Bimestre bimestre2 = new Bimestre(null, BimestreEnum.BIMESTRE_2, LocalDate.of(2020, 4, 23), LocalDate.of(2020, 6, 25));
        Bimestre bimestre3 = new Bimestre(null, BimestreEnum.BIMESTRE_3, LocalDate.of(2020, 7, 21), LocalDate.of(2020, 9, 18));
        Bimestre bimestre4 = new Bimestre(null, BimestreEnum.BIMESTRE_4, LocalDate.of(2020, 10, 5), LocalDate.of(2020, 12, 7));
        bimestreRepository.saveAll(Arrays.asList(bimestre1, bimestre2, bimestre3, bimestre4));

        //adicionando Avaliacoes por bimestre do Pedro no banco de dados
        //1° Bimestre - Pedro
        Avaliacao avaliacao1PedroB1 = new Avaliacao(null, 6.0, partSalaDeAula, bimestre1, Pedro);
        Avaliacao avaliacao2PedroB1 = new Avaliacao(null, 7.5, entregaDasTarefas, bimestre1, Pedro);
        Avaliacao avaliacao3PedroB1 = new Avaliacao(null, 9.0, trabalhoBimestral, bimestre1, Pedro);
        Avaliacao avaliacao4PedroB1 = new Avaliacao(null, 8.0, provaBimestral, bimestre1, Pedro);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1PedroB1, avaliacao2PedroB1, avaliacao3PedroB1, avaliacao4PedroB1));

        //2° Bimestre - Pedro
        Avaliacao avaliacao1PedroB2 = new Avaliacao(null, 8.0, partSalaDeAula, bimestre2, Pedro);
        Avaliacao avaliacao2PedroB2 = new Avaliacao(null, 9.5, entregaDasTarefas, bimestre2, Pedro);
        Avaliacao avaliacao3PedroB2 = new Avaliacao(null, 9.0, trabalhoBimestral, bimestre2, Pedro);
        Avaliacao avaliacao4PedroB2 = new Avaliacao(null, 8.5, provaBimestral, bimestre2, Pedro);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1PedroB2, avaliacao2PedroB2, avaliacao3PedroB2, avaliacao4PedroB2));

        //3° Bimestre - Pedro
        Avaliacao avaliacao1PedroB3 = new Avaliacao(null, 9.0, partSalaDeAula, bimestre3, Pedro);
        Avaliacao avaliacao2PedroB3 = new Avaliacao(null, 10.0, entregaDasTarefas, bimestre3, Pedro);
        Avaliacao avaliacao3PedroB3 = new Avaliacao(null, 9.5, trabalhoBimestral, bimestre3, Pedro);
        Avaliacao avaliacao4PedroB3 = new Avaliacao(null, 9.5, provaBimestral, bimestre3, Pedro);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1PedroB3, avaliacao2PedroB3, avaliacao3PedroB3, avaliacao4PedroB3));

        //4° Bimestre - Pedro
        Avaliacao avaliacao1PedroB4 = new Avaliacao(null, 8.0, partSalaDeAula, bimestre4, Pedro);
        Avaliacao avaliacao2PedroB4 = new Avaliacao(null, 9.0, entregaDasTarefas, bimestre4, Pedro);
        Avaliacao avaliacao3PedroB4 = new Avaliacao(null, 8.5, trabalhoBimestral, bimestre4, Pedro);
        Avaliacao avaliacao4PedroB4 = new Avaliacao(null, 9.0, provaBimestral, bimestre4, Pedro);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1PedroB4, avaliacao2PedroB4, avaliacao3PedroB4, avaliacao4PedroB4));

        //adicionando Avaliacoes por bimestre da Maria no banco de dados
        //1° Bimestre - Maria
        Avaliacao avaliacao1MariaB1 = new Avaliacao(null, 10.0, partSalaDeAula, bimestre1, Maria);
        Avaliacao avaliacao2MariaB1 = new Avaliacao(null, 10.0, entregaDasTarefas, bimestre1, Maria);
        Avaliacao avaliacao3MariaB1 = new Avaliacao(null, 10.0, trabalhoBimestral, bimestre1, Maria);
        Avaliacao avaliacao4MariaB1 = new Avaliacao(null, 10.0, provaBimestral, bimestre1,Maria);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1MariaB1, avaliacao2MariaB1, avaliacao3MariaB1, avaliacao4MariaB1));

        //2° Bimestre - Maria
        Avaliacao avaliacao1MariaB2 = new Avaliacao(null, 10.0, partSalaDeAula, bimestre2, Maria);
        Avaliacao avaliacao2MariaB2 = new Avaliacao(null, 10.0, entregaDasTarefas, bimestre2, Maria);
        Avaliacao avaliacao3MariaB2 = new Avaliacao(null, 10.0, trabalhoBimestral, bimestre2, Maria);
        Avaliacao avaliacao4MariaB2 = new Avaliacao(null, 10.0, provaBimestral, bimestre2, Maria);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1MariaB2, avaliacao2MariaB2, avaliacao3MariaB2, avaliacao4MariaB2));

        //3° Bimestre - Maria
        Avaliacao avaliacao1MariaB3 = new Avaliacao(null, 10.0, partSalaDeAula, bimestre3, Maria);
        Avaliacao avaliacao2MariaB3 = new Avaliacao(null, 10.0, entregaDasTarefas, bimestre3, Maria);
        Avaliacao avaliacao3MariaB3 = new Avaliacao(null, 10.0, trabalhoBimestral, bimestre3, Maria);
        Avaliacao avaliacao4MariaB3 = new Avaliacao(null, 10.0, provaBimestral, bimestre3, Maria);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1MariaB3, avaliacao2MariaB3, avaliacao3MariaB3, avaliacao4MariaB3));

        //4° Bimestre - Maria
        Avaliacao avaliacao1MariaB4 = new Avaliacao(null, 10.0, partSalaDeAula, bimestre4, Maria);
        Avaliacao avaliacao2MariaB4 = new Avaliacao(null, 10.0, entregaDasTarefas, bimestre4, Maria);
        Avaliacao avaliacao3MariaB4 = new Avaliacao(null, 10.0, trabalhoBimestral, bimestre4, Maria);
        Avaliacao avaliacao4MariaB4 = new Avaliacao(null, 10.0, provaBimestral, bimestre4, Maria);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1MariaB4, avaliacao2MariaB4, avaliacao3MariaB4, avaliacao4MariaB4));

    }

}
