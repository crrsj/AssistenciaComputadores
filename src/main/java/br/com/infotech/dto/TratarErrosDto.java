package br.com.infotech.dto;

import org.springframework.http.HttpStatus;

public record TratarErrosDto(
		
		HttpStatus status,
		
		String mensagem) {

}
