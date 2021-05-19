package arthur.com.example.escola.Configuracao;

import arthur.com.example.escola.Aluno.Aluno;
import arthur.com.example.escola.Aluno.AlunoRepository;
import arthur.com.example.escola.Avaliacao.Avaliacao;
import arthur.com.example.escola.Avaliacao.AvaliacaoRepository;
import arthur.com.example.escola.Bimestre.Bimestre;
import arthur.com.example.escola.Bimestre.BimestreRepository;
import arthur.com.example.escola.Enums.BimestreEnum;
import arthur.com.example.escola.Presenca.Presenca;
import arthur.com.example.escola.Presenca.PresencaRepository;
import arthur.com.example.escola.TipoAvaliacao.TipoAvaliacao;
import arthur.com.example.escola.TipoAvaliacao.TipoAvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration //fala que essa classe é especifica para configuração

public class TesteConfig implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository; //injecao de dependencia

    @Autowired
    private TipoAvaliacaoRepository tipoAvaliacaoRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private BimestreRepository bimestreRepository;

    @Autowired
    private PresencaRepository presencaRepository;

    @Override
    public void run(String... args) throws Exception {//irá executar o método run assim que o programa for executado


        //adicionando alunos ao banco de dados

        Aluno Pedro = new Aluno(99332737L, "Pedro", "pedro@gmail.com", "99257629");
        Aluno Maria = new Aluno(66887734L, "Maria", "maria@gmail.com", "98274531");
        Aluno Jose = new Aluno(22553434L, "Jose", "jose@gmail.com", "99453762");
        alunoRepository.saveAll(Arrays.asList(Pedro, Maria, Jose));

        //adicionando tipoAvaliacao ao banco de dados

        TipoAvaliacao partSalaDeAula = new TipoAvaliacao( "Participação em sala de aula", 1.5);
        TipoAvaliacao entregaDasTarefas = new TipoAvaliacao("Entrega das tarefas", 2.5);
        TipoAvaliacao trabalhoBimestral = new TipoAvaliacao("Trabalho bimestral", 3.0);
        TipoAvaliacao provaBimestral = new TipoAvaliacao("Prova bimestral", 3.0);
        tipoAvaliacaoRepository.saveAll(Arrays.asList(partSalaDeAula, entregaDasTarefas, trabalhoBimestral, provaBimestral));


        //adcionando Bimestre ao bando de dados
        Bimestre bimestre1 = new Bimestre(BimestreEnum.BIMESTRE_1, LocalDate.of(2020, 2, 4), LocalDate.of(2020, 3, 15));
        Bimestre bimestre2 = new Bimestre(BimestreEnum.BIMESTRE_2, LocalDate.of(2020, 4, 23), LocalDate.of(2020, 6, 2));
        Bimestre bimestre3 = new Bimestre(BimestreEnum.BIMESTRE_3, LocalDate.of(2020, 7, 21), LocalDate.of(2020, 8, 30));
        Bimestre bimestre4 = new Bimestre(BimestreEnum.BIMESTRE_4, LocalDate.of(2020, 10, 5), LocalDate.of(2020, 11, 14));
        bimestreRepository.saveAll(Arrays.asList(bimestre1, bimestre2, bimestre3, bimestre4));

        //adicionando Avaliacoes por bimestre do Pedro no banco de dados
        //1° Bimestre - Pedro
        Avaliacao avaliacao1PedroB1 = new Avaliacao( 6.0, partSalaDeAula, bimestre1, Pedro);
        Avaliacao avaliacao2PedroB1 = new Avaliacao(6.0, entregaDasTarefas, bimestre1, Pedro);
        Avaliacao avaliacao3PedroB1 = new Avaliacao(6.0, trabalhoBimestral, bimestre1, Pedro);
        Avaliacao avaliacao4PedroB1 = new Avaliacao(2.0, provaBimestral, bimestre1, Pedro);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1PedroB1, avaliacao2PedroB1, avaliacao3PedroB1, avaliacao4PedroB1));

        //2° Bimestre - Pedro
        Avaliacao avaliacao1PedroB2 = new Avaliacao(5.0, partSalaDeAula, bimestre2, Pedro);
        Avaliacao avaliacao2PedroB2 = new Avaliacao(6.0, entregaDasTarefas, bimestre2, Pedro);
        Avaliacao avaliacao3PedroB2 = new Avaliacao(6.0, trabalhoBimestral, bimestre2, Pedro);
        Avaliacao avaliacao4PedroB2 = new Avaliacao( 6.0, provaBimestral, bimestre2, Pedro);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1PedroB2, avaliacao2PedroB2, avaliacao3PedroB2, avaliacao4PedroB2));

        //3° Bimestre - Pedro
        Avaliacao avaliacao1PedroB3 = new Avaliacao( 6.0, partSalaDeAula, bimestre3, Pedro);
        Avaliacao avaliacao2PedroB3 = new Avaliacao( 6.0, entregaDasTarefas, bimestre3, Pedro);
        Avaliacao avaliacao3PedroB3 = new Avaliacao( 6.5, trabalhoBimestral, bimestre3, Pedro);
        Avaliacao avaliacao4PedroB3 = new Avaliacao( 4.0, provaBimestral, bimestre3, Pedro);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1PedroB3, avaliacao2PedroB3, avaliacao3PedroB3, avaliacao4PedroB3));

        //4° Bimestre - Pedro
        Avaliacao avaliacao1PedroB4 = new Avaliacao( 6.0, partSalaDeAula, bimestre4, Pedro);
        Avaliacao avaliacao2PedroB4 = new Avaliacao( 6.0, entregaDasTarefas, bimestre4, Pedro);
        Avaliacao avaliacao3PedroB4 = new Avaliacao( 6.5, trabalhoBimestral, bimestre4, Pedro);
        Avaliacao avaliacao4PedroB4 = new Avaliacao( 6.0, provaBimestral, bimestre4, Pedro);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1PedroB4, avaliacao2PedroB4, avaliacao3PedroB4, avaliacao4PedroB4));

        //adicionando Avaliacoes por bimestre da Maria no banco de dados
        //1° Bimestre - Maria
        Avaliacao avaliacao1MariaB1 = new Avaliacao( 10.0, partSalaDeAula, bimestre1, Maria);
        Avaliacao avaliacao2MariaB1 = new Avaliacao( 10.0, entregaDasTarefas, bimestre1, Maria);
        Avaliacao avaliacao3MariaB1 = new Avaliacao( 10.0, trabalhoBimestral, bimestre1, Maria);
        Avaliacao avaliacao4MariaB1 = new Avaliacao( 10.0, provaBimestral, bimestre1,Maria);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1MariaB1, avaliacao2MariaB1, avaliacao3MariaB1, avaliacao4MariaB1));

        //2° Bimestre - Maria
        Avaliacao avaliacao1MariaB2 = new Avaliacao( 10.0, partSalaDeAula, bimestre2, Maria);
        Avaliacao avaliacao2MariaB2 = new Avaliacao( 10.0, entregaDasTarefas, bimestre2, Maria);
        Avaliacao avaliacao3MariaB2 = new Avaliacao( 10.0, trabalhoBimestral, bimestre2, Maria);
        Avaliacao avaliacao4MariaB2 = new Avaliacao( 10.0, provaBimestral, bimestre2, Maria);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1MariaB2, avaliacao2MariaB2, avaliacao3MariaB2, avaliacao4MariaB2));

        //3° Bimestre - Maria
        Avaliacao avaliacao1MariaB3 = new Avaliacao( 10.0, partSalaDeAula, bimestre3, Maria);
        Avaliacao avaliacao2MariaB3 = new Avaliacao( 10.0, entregaDasTarefas, bimestre3, Maria);
        Avaliacao avaliacao3MariaB3 = new Avaliacao(10.0, trabalhoBimestral, bimestre3, Maria);
        Avaliacao avaliacao4MariaB3 = new Avaliacao( 10.0, provaBimestral, bimestre3, Maria);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1MariaB3, avaliacao2MariaB3, avaliacao3MariaB3, avaliacao4MariaB3));

        //4° Bimestre - Maria
        Avaliacao avaliacao1MariaB4 = new Avaliacao( 10.0, partSalaDeAula, bimestre4, Maria);
        Avaliacao avaliacao2MariaB4 = new Avaliacao(10.0, entregaDasTarefas, bimestre4, Maria);
        Avaliacao avaliacao3MariaB4 = new Avaliacao( 10.0, trabalhoBimestral, bimestre4, Maria);
        Avaliacao avaliacao4MariaB4 = new Avaliacao( 10.0, provaBimestral, bimestre4, Maria);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1MariaB4, avaliacao2MariaB4, avaliacao3MariaB4, avaliacao4MariaB4));

        //adicionando Avaliacoes por bimestre do Jose no banco de dados
        //1° Bimestre - Jose
        Avaliacao avaliacao1JoseB1 = new Avaliacao( 5.0, partSalaDeAula, bimestre1, Jose);
        Avaliacao avaliacao2JoseB1 = new Avaliacao( 5.5, entregaDasTarefas, bimestre1, Jose);
        Avaliacao avaliacao3JoseB1 = new Avaliacao( 5.0, trabalhoBimestral, bimestre1, Jose);
        Avaliacao avaliacao4JoseB1 = new Avaliacao( 10.0, provaBimestral, bimestre1,Jose);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1JoseB1, avaliacao2JoseB1, avaliacao3JoseB1, avaliacao4JoseB1));

        //2° Bimestre - Jose
        Avaliacao avaliacao1JoseB2 = new Avaliacao( 5.0, partSalaDeAula, bimestre2, Jose);
        Avaliacao avaliacao2JoseB2 = new Avaliacao( 5.0, entregaDasTarefas, bimestre2, Jose);
        Avaliacao avaliacao3JoseB2 = new Avaliacao( 5.5, trabalhoBimestral, bimestre2, Jose);
        Avaliacao avaliacao4JoseB2 = new Avaliacao( 6.0, provaBimestral, bimestre2, Jose);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1JoseB2, avaliacao2JoseB2, avaliacao3JoseB2, avaliacao4JoseB2));

        //3° Bimestre - Jose
        Avaliacao avaliacao1JoseB3 = new Avaliacao( 5.0, partSalaDeAula, bimestre3, Jose);
        Avaliacao avaliacao2JoseB3 = new Avaliacao( 5.0, entregaDasTarefas, bimestre3, Jose);
        Avaliacao avaliacao3JoseB3 = new Avaliacao( 5.5, trabalhoBimestral, bimestre3, Jose);
        Avaliacao avaliacao4JoseB3 = new Avaliacao( 5.0, provaBimestral, bimestre3, Jose);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1JoseB3, avaliacao2JoseB3, avaliacao3JoseB3, avaliacao4JoseB3));

        //4° Bimestre - Jose
        Avaliacao avaliacao1JoseB4 = new Avaliacao( 5.0, partSalaDeAula, bimestre4, Jose);
        Avaliacao avaliacao2JoseB4 = new Avaliacao( 5.5, entregaDasTarefas, bimestre4, Jose);
        Avaliacao avaliacao3JoseB4 = new Avaliacao( 4.5, trabalhoBimestral, bimestre4, Jose);
        Avaliacao avaliacao4JoseB4 = new Avaliacao( 3.0, provaBimestral, bimestre4, Jose);
        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1JoseB4, avaliacao2JoseB4, avaliacao3JoseB4, avaliacao4JoseB4));

        //Adicionando presenças do Pedro

        Presenca presencaPedroB1 = new Presenca(5, bimestre1, Pedro);
        Presenca presencaPedroB2 = new Presenca(4, bimestre2, Pedro);
        Presenca presencaPedroB3 = new Presenca(3, bimestre3, Pedro);
        Presenca presencaPedroB4 = new Presenca(2, bimestre4, Pedro);
        presencaRepository.saveAll(Arrays.asList(presencaPedroB1, presencaPedroB2, presencaPedroB3, presencaPedroB4));

        //Adicionando presenças da Maria

        Presenca presencaMariaB1 = new Presenca(2, bimestre1, Maria);
        Presenca presencaMariaB2 = new Presenca(1, bimestre2, Maria);
        Presenca presencaMariaB3 = new Presenca(2, bimestre3, Maria);
        Presenca presencaMariaB4 = new Presenca(3, bimestre4, Maria);
        presencaRepository.saveAll(Arrays.asList(presencaMariaB1, presencaMariaB2, presencaMariaB3, presencaMariaB4));

        //Adicionando presenças do Jose

        Presenca presencaJoseB1 = new Presenca(12, bimestre1, Jose);
        Presenca presencaJoseB2 = new Presenca(15, bimestre2, Jose);
        Presenca presencaJoseB3 = new Presenca(19, bimestre3, Jose);
        Presenca presencaJoseB4 = new Presenca(20, bimestre4, Jose);
        presencaRepository.saveAll(Arrays.asList(presencaJoseB1, presencaJoseB2, presencaJoseB3, presencaJoseB4));

        //associações dos alunos aos bimestres
        Pedro.getBimestres().addAll(Arrays.asList(bimestre1, bimestre2, bimestre3, bimestre4));
        Maria.getBimestres().addAll(Arrays.asList(bimestre1, bimestre2, bimestre3, bimestre4));
        Jose.getBimestres().addAll(Arrays.asList(bimestre1, bimestre2, bimestre3, bimestre4));
        alunoRepository.saveAll(Arrays.asList(Pedro, Maria, Jose));

    }

}
