package br.com.desafio.familia.casa.dto;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.desafio.familia.casa.model.Pessoa;

public class PessoaDTO {

	private Long id;
	private String nome;
	private BigDecimal renda;
	private Date dataNascimento;
	
	public PessoaDTO(Pessoa pessoa) {
		super();
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.renda = pessoa.getRenda();
		this.dataNascimento = pessoa.getDataNascimento();
	}
	
	
	public Integer getIdade() {

		Calendar dataNascimentoCalendar  = new GregorianCalendar();
		dataNascimentoCalendar.setTime(this.dataNascimento);
		Calendar hojeCalendar = Calendar.getInstance();
		
		Integer idade = hojeCalendar.get(Calendar.YEAR) - dataNascimentoCalendar.get(Calendar.YEAR);
		dataNascimentoCalendar.add(Calendar.YEAR, idade);

		if (hojeCalendar.before(dataNascimentoCalendar)) {
			idade--;
		}

		return idade;
	
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public BigDecimal getRenda() {
		return renda;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	

}
