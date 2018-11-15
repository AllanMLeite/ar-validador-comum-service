package com.ar.validadorcomumservice.cpf;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidadorSituacaoCpfDto {

	@NotBlank(message = "CPF nao pode ser nulo")
	private String cpf;
	
	@JsonCreator
	public ValidadorSituacaoCpfDto(@JsonProperty("cpf") @NotBlank(message = "CPF nao pode ser nulo") String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
}
