package br.com.desafio.familia.casa.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.familia.casa.model.Familia;

public class FamiliaDTO {
	
	private String nome;	
	private Integer pontos = 0;	
	private List<PessoaDTO> pessoas;
	private List<PessoaDTO> dependentes;
	private BigDecimal renda;

	public FamiliaDTO(Familia familia) {
		
		super();
		this.nome = familia.getNome();
		this.pessoas = new ArrayList<PessoaDTO>();
		
		familia.getPessoas().forEach(pessoa -> {
			this.pessoas.add(new PessoaDTO(pessoa));
		});

	}
		
	public List<PessoaDTO> getDependentes() {
		if(dependentes == null) {
			dependentes = new ArrayList<PessoaDTO>();
		}
		return dependentes;
	}

	public void setDependentes(List<PessoaDTO> dependentes) {
		this.dependentes = dependentes;
	}

	public String getNome() {
		return nome;
	}

	public List<PessoaDTO> getPessoas() {
		if(pessoas == null) {
			pessoas = new ArrayList<PessoaDTO>();
		}
		return pessoas;
	}
	
	public Integer getPontos() {		
		return pontos;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}


	public void setPessoas(List<PessoaDTO> pessoas) {
		this.pessoas = pessoas;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}
			
	
}
