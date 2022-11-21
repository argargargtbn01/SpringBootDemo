package LearningSpringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomerExceptionHandler {
    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handlerException(Exception ex, WebRequest req){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
    }

    @ExceptionHandler(NotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handlerNotFoundException(NotFoundException ex, WebRequest req){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
    }


}
