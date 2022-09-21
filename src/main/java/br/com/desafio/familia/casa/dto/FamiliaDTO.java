package br.com.desafio.familia.casa.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.desafio.familia.casa.enums.FaixaDeRendaEnum;
import br.com.desafio.familia.casa.enums.QuantidadeDependentesEnum;
import br.com.desafio.familia.casa.model.Familia;

public class FamiliaDTO {
	
	private final Integer IDADE_MAXIMA_DEPENDENTES = 18;

	private String nome;	
	private Integer pontos = 0;	
	private List<PessoaDTO> pessoas;

	public FamiliaDTO(Familia familia) {
		
		super();
		this.nome = familia.getNome();
		this.pessoas = new ArrayList<PessoaDTO>();
		
		familia.getPessoas().forEach(pessoa -> {
			this.pessoas.add(new PessoaDTO(pessoa));
		});
		
		calcularPontosPorRenda();
		calcularPontosPorDependentes();
	}
	
	
	private void calcularPontosPorDependentes() {
		this.pontos += 
				QuantidadeDependentesEnum.getPorQuantidadeDependentes(
						this.getQuantidadeDependentes()
				).getPontos();		
	}

	private void calcularPontosPorRenda() {
		this.pontos += 
				FaixaDeRendaEnum.getPorRenda(this.getRanda()).getPontos();		
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
				.filter(pessoa -> pessoa.getIdade() < IDADE_MAXIMA_DEPENDENTES)
				.collect(Collectors.toList());
	}


	public String getNome() {
		return nome;
	}

	public List<PessoaDTO> getPessoas() {
		return pessoas;
	}
	
	public Integer getPontos() {		
		return pontos;
	}
		
	
	
}
