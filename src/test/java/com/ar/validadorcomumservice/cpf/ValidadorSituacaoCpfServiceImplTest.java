package com.ar.validadorcomumservice.cpf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ValidadorSituacaoCpfServiceImplTest {

	private ValidadorSituacaoCpfServiceImpl service;

	@Before
	public void setup() {
		service = new ValidadorSituacaoCpfServiceImpl();
	}

	@Test
	public void deveRetornarFalseParaCpfIrregular() {
		assertFalse(service.validarSituacaoCpf("01234567890"));
	}

	@Test
	public void deveRetornarTrueParaCpfRegular() {
		assertTrue(service.validarSituacaoCpf("29355663005"));
		assertTrue(service.validarSituacaoCpf("36213186077"));
		assertTrue(service.validarSituacaoCpf("15578926010"));
		assertTrue(service.validarSituacaoCpf("55621955005"));
		assertTrue(service.validarSituacaoCpf("56225555072"));
	}
}
