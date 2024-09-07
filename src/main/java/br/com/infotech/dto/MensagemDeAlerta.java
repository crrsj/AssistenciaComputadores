package br.com.infotech.dto;


import org.springframework.validation.FieldError;

public record MensagemDeAlerta(
		
		String campo,
		
		String mensagem) {
		
	public MensagemDeAlerta(FieldError erro) {
		this(
				erro.getField(),
				erro.getDefaultMessage());
	}
}
