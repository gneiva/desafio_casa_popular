package br.com.desafio.familia.casa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import br.com.desafio.familia.casa.dto.FamiliaDTO;
import br.com.desafio.familia.casa.model.Familia;
import br.com.desafio.familia.casa.model.Pessoa;

class FamiliaServiceTest {

	@Test
	void calcularRenda() {
		FamiliaService service = new FamiliaService();
		Familia familia = new Familia();
		
		familia.setNome("Familia");
		familia.setPessoas(new HashSet<Pessoa>());
		
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setRenda(new BigDecimal("1000"));
		pessoa1.setDataNascimento(new Date());
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setRenda(new BigDecimal("1000"));
		pessoa2.setDataNascimento(new Date());
		
		familia.getPessoas().add(pessoa1);
		familia.getPessoas().add(pessoa2);
		
		FamiliaDTO familiaDTO = service.calcularPontos(familia);
		
		assertEquals(new BigDecimal("2000"), familiaDTO.getRenda());
		
	}
	
	@Test
	void calcularRendaNegativa() {
		FamiliaService service = new FamiliaService();
		Familia familia = new Familia();
		
		familia.setNome("Familia");
		familia.setPessoas(new HashSet<Pessoa>());
		
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setRenda(new BigDecimal("1000"));
		pessoa1.setDataNascimento(new Date());
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setRenda(new BigDecimal("-1000"));
		pessoa2.setDataNascimento(new Date());
		
		familia.getPessoas().add(pessoa1);
		familia.getPessoas().add(pessoa2);
		
		FamiliaDTO familiaDTO = service.calcularPontos(familia);
		
		assertEquals(new BigDecimal("1000"), familiaDTO.getRenda());
		
	}
	
	@Test
	void calcularDependentes() {
		FamiliaService service = new FamiliaService();
		Familia familia = new Familia();
		
		familia.setNome("Familia");
		familia.setPessoas(new HashSet<Pessoa>());
		
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setDataNascimento(new Date());
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setDataNascimento(new Date());
		
		familia.getPessoas().add(pessoa1);
		familia.getPessoas().add(pessoa2);
		
		FamiliaDTO familiaDTO = service.calcularPontos(familia);
		
		assertEquals(Integer.valueOf(2), familiaDTO.getDependentes().size());
		
	}
	
	

}
