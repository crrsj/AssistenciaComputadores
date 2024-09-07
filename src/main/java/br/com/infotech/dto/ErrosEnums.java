package br.com.infotech.dto;

import org.springframework.http.HttpStatus;

public record ErrosEnums(
		
		HttpStatus status, 
		
		String mensagem) {

}
