package br.com.desafio.familia.casa.enums;

import java.math.BigDecimal;

public enum FaixaDeRendaEnum {
	
	RENDA_BAIXA(BigDecimal.ZERO, new BigDecimal(900), 5), 
	RENDA_MEDIA(new BigDecimal(901), new BigDecimal(1500), 3), 
	RENDA_ALTA(new BigDecimal(1500), new BigDecimal(-1), 0);

	private BigDecimal minimo;
	private BigDecimal maximo;
	private Integer pontos;
	
	FaixaDeRendaEnum(BigDecimal minimo, BigDecimal maximo, Integer pontos){
		this.minimo = minimo;
		this.maximo = maximo;
		this.pontos = pontos;		
	}
	
	
	
	public BigDecimal getMinimo() {
		return minimo;
	}



	public BigDecimal getMaximo() {
		return maximo;
	}



	public Integer getPontos() {
		return pontos;
	}



	public static FaixaDeRendaEnum getPorRenda(BigDecimal renda){
		for (FaixaDeRendaEnum rendaEnum : FaixaDeRendaEnum.values()) {
			if(renda.compareTo(rendaEnum.maximo) < 1 
					&& renda.compareTo(rendaEnum.minimo) > 0) {
				
				return rendaEnum;
			
			}
		}
		
		return RENDA_ALTA;
	}
}
