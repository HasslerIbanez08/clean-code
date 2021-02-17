package co.com.personalsoft.springbootdocker.execptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFountException extends RuntimeException {
    public ModelNotFountException(String message) {
        super(message);
    }
}
