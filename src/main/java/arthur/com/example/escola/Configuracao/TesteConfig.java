package arthur.com.example.escola.Configuracao;

import arthur.com.example.escola.Aluno.Aluno;
import arthur.com.example.escola.Aluno.Repository.AlunoRepository;
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

    @Override
    public void run(String... args) throws Exception {//irá executar o método run assim que o programa for executado



        Aluno Pedro = new Aluno(99332737L, "Pedro", "pedro@gmail.com", "99257629");
        Aluno Maria = new Aluno(66887734L, "Maria", "maria@gmail.com", "98274531");
        Aluno Jose = new Aluno(22553434L, "Jose", "jose@gmail.com", "99453762");
        alunoRepository.saveAll(Arrays.asList(Pedro, Maria, Jose));


    }

}
