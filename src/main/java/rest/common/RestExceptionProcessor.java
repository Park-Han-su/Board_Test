package rest.common;

import java.sql.SQLException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("rest")
public class RestExceptionProcessor {
	
	Logger logger = LoggerFactory.getLogger(RestExceptionProcessor.class);
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity runtimeException(RuntimeException ex) {
		logger.error(ex.getMessage(), ex);
		return ResponseEntity
				.status(500)
				.body(new ResultObject("1", ex.getMessage()));
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity sqlException(SQLException ex) {
		logger.error(ex.getMessage(), ex);
		return ResponseEntity
				.status(500)
				.body(new ResultObject("1", ex.getMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity handleBindException(MethodArgumentNotValidException ex) {
		logger.error(ex.getMessage(), ex);
		String errorCodes = ex.getBindingResult().getAllErrors()
				.stream()
				.map(error -> error.getCodes()[0])
				.collect(Collectors.joining(","));
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new ResultObject("1", errorCodes));
	}
}
