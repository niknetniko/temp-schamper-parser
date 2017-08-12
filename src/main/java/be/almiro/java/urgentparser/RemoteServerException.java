package be.almiro.java.urgentparser;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Niko Strijbol
 */
@ResponseStatus(value= HttpStatus.BAD_GATEWAY)
public class RemoteServerException extends Exception {

}
