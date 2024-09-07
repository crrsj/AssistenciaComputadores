package br.com.infotech.infra;

import org.springframework.http.HttpStatus;

public record TratarErrosDto(
		
		HttpStatus status,
		
		String mensagem) {

}
