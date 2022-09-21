package br.com.desafio.familia.casa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "familia")
public class Familia {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_familia")
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy = "familia", cascade = CascadeType.ALL) 
    private Set<Pessoa> pessoas;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Set<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	
}
