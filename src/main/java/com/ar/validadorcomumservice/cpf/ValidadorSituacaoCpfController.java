package com.ar.validadorcomumservice.cpf;

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
	public ResponseEntity<Boolean> validarSituacaoCpf(@RequestBody(required = true) String cpf) {
		
		boolean isSituacaoRegular = service.validarSituacaoCpf(cpf);
		
		return ResponseEntity.ok(isSituacaoRegular);
	}
}
