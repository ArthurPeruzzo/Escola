package arthur.com.example.escola.Excecoes;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("id nao encontrado " + id);
    }
}
