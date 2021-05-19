package arthur.com.example.escola.Excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
@ControllerAdvice //intercepta as excecoes para o objeto executar tratamento
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class) //serve para interceptar execao do tipo resource para cair nesse metodo
        public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){

            String error = "Recurso não encontrado";

            HttpStatus status = HttpStatus.NOT_FOUND;

            StandardError er = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

            return ResponseEntity.status(status).body(er);
        }

        @ExceptionHandler(DatabaseException.class)//serve para interceptar execao do tipo database para cair nesse metodo
        public ResponseEntity<StandardError> dataBase(DatabaseException e, HttpServletRequest request){

            String error = "erro de banco de dados";

            HttpStatus status = HttpStatus.BAD_REQUEST;

            StandardError er = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

            return ResponseEntity.status(status).body(er);
        }
    }
