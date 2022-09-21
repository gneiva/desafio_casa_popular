package br.com.desafio.familia.casa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.familia.casa.model.Familia;

public interface FamiliaRepository extends JpaRepository<Familia, Integer> {

	List<Familia> findAll();

}
