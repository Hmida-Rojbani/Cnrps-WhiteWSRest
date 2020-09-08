package tn.cnrps.ws.rest.white.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class WhiteTestExpHandller {
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<ErrorResponse>   StudentNumberFormatExceptionHandler(NumberFormatException e) {
		return new ResponseEntity<>(new ErrorResponse("Cannot convert to ID (int)",e.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	//@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse>   StudentExceptionHandler(Exception e) {
		return new ResponseEntity<>(new ErrorResponse("Error","Error"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse>   StudentValidationExceptionHandler(MethodArgumentNotValidException e) {
		return new ResponseEntity<>(new ErrorResponse("Arguments not valid : "+e.getBindingResult().getFieldError().getField(),e.getBindingResult().getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	}

}
