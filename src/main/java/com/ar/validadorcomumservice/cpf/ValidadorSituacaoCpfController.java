package com.ar.validadorcomumservice.cpf;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidadorSituacaoCpfController {

	@Autowired
	private ValidadorSituacaoCpfService service;

	@RequestMapping(value = "/situacao/cpf", method = RequestMethod.POST)
	public ResponseEntity<Boolean> validarSituacaoCpf(@RequestBody @Valid ValidadorSituacaoCpfDto dto) {
		
		boolean isSituacaoRegular = service.validarSituacaoCpf(dto.getCpf());
		
		return ResponseEntity.ok(isSituacaoRegular);
	}
}
