package br.com.desafio.familia.casa.enums;

public enum QuantidadeDependentesEnum {
	
	NENHUM(0, 0), 
	ATE_2(1, 2), 
	MAIS_DE_3(3, 3);

	private Integer quantidade;
	private Integer pontos;
	
	QuantidadeDependentesEnum(Integer quantidade, Integer pontos){
		this.quantidade = quantidade;
		this.pontos = pontos;		
	}
		
	public Integer getQuantidade() {
		return quantidade;
	}

	public Integer getPontos() {
		return pontos;
	}


	public static QuantidadeDependentesEnum getPorQuantidadeDependentes(Integer quantidadeDependentes){
		for (QuantidadeDependentesEnum dependenteEnum : QuantidadeDependentesEnum.values()) {
			if(dependenteEnum.getQuantidade() >= quantidadeDependentes) {
				return dependenteEnum;
			}
		}		
		return NENHUM;
	}
}
