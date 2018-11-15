package com.ar.validadorcomumservice.cpf;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ValidadorSituacaoCpfController.class)
public class ValidadorSituacaoCpfControllerTest {

	private static final String ENDPOINT_SITUACAO_CPF = "/situacao/cpf";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ValidadorSituacaoCpfService service;

	@Test
	public void deveLancarExcecaoQuandoCpfNaoForInformado() throws Exception {
		this.mockMvc.perform(post(ENDPOINT_SITUACAO_CPF).content(StringUtils.EMPTY)).andExpect(status().isBadRequest());
	}

	@Test
	public void deveRetornarSituacaoDoCpf() throws Exception {

		Mockito.doReturn(false).when(service).validarSituacaoCpf(Mockito.anyString());

		this.mockMvc.perform(post(ENDPOINT_SITUACAO_CPF).content("\"cpf\":\"01234567890\"")).andExpect(status().isOk())
				.andExpect(content().string(containsString("false")));
		;
	}
}
