package br.com.infotech.infra;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.infotech.dto.ErrosEnums;
import br.com.infotech.dto.MensagemDeAlerta;
import br.com.infotech.dto.TratarErrosDto;

@RestControllerAdvice
public class TratamentoDeErros {
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<TratarErrosDto>tratarErros(){	
		var erros = new TratarErrosDto(HttpStatus.NOT_FOUND, "Cliente não encontrado");
		return new ResponseEntity<>(erros,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>camposEmBranco(MethodArgumentNotValidException ex){
		var erro = ex.getFieldErrors();
		return ResponseEntity.badRequest().
				body(erro.stream().map(MensagemDeAlerta::new).toList());
	}

   @ExceptionHandler(HttpMessageNotReadableException.class)
   public ResponseEntity<ErrosEnums>tratarErrosEnums(){
	   var errosEnum = new ErrosEnums(HttpStatus.BAD_REQUEST,"Campo enum(s) incorreto(s)");
	   return ResponseEntity.badRequest().body(errosEnum);
   }
}
