package br.com.desafio.familia.casa.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.desafio.familia.casa.model.Familia;

public class FamiliaDTO {

	private String nome;
	
	private List<PessoaDTO> pessoas;

	public FamiliaDTO(Familia familia) {
		
		super();
		this.nome = familia.getNome();
		this.pessoas = new ArrayList<PessoaDTO>();
		
		familia.getPessoas().forEach(pessoa -> {
			this.pessoas.add(new PessoaDTO(pessoa));
		});
	}
	
	public BigDecimal getRanda() {
		BigDecimal renda = BigDecimal.ZERO;
		for (PessoaDTO pessoaDTO : pessoas) {
			renda = renda.add(pessoaDTO.getRenda());
		}
		return renda;
	}

	public Integer getQuantidadeDependentes() {
		return getDependentes().size();
		
	}
	
	public List<PessoaDTO> getDependentes(){
		return this.pessoas.stream()
				.filter(pessoa -> pessoa.getIdade() < 18)
				.collect(Collectors.toList());
	}
	
	
	public Integer getPontos() {
		Integer pontos = 0;
		return pontos;
	}

	public String getNome() {
		return nome;
	}

	public List<PessoaDTO> getPessoas() {
		return pessoas;
	}
		
	
	
}
