package br.com.infotech.infra;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoDeErros {
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<TratarErrosDto>tratarErros(){	
		var erros = new TratarErrosDto(HttpStatus.NOT_FOUND, "Cliente não encontrado");
		return new ResponseEntity<>(erros,HttpStatus.NOT_FOUND);
	}

}
