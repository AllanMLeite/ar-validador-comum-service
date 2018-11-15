package com.ar.validadorcomumservice.cpf;

import org.springframework.stereotype.Service;

@Service
public class ValidadorSituacaoCpfServiceImpl implements ValidadorSituacaoCpfService {

	private static final String CPF_IRREGULAR = "01234567890";

	@Override
	public boolean validarSituacaoCpf(String cpf) {
		return !cpf.equals(CPF_IRREGULAR);
	}

}
