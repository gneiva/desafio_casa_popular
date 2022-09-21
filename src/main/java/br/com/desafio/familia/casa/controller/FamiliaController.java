package br.com.desafio.familia.casa.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.familia.casa.dto.FamiliaDTO;
import br.com.desafio.familia.casa.model.Familia;
import br.com.desafio.familia.casa.repository.FamiliaRepository;

@RestController
@RequestMapping("/familia")
public class FamiliaController {
	
	@Autowired
	private FamiliaRepository familiaRepository;
	
	@GetMapping("/rank")
	public ResponseEntity<Object> consultar() {
		try {
			List<Familia> familias = familiaRepository.findAll();
			List<FamiliaDTO> familiasDTO = familias.stream().map(familia -> new FamiliaDTO(familia)).collect(Collectors.toList());
			return ResponseEntity.ok(familiasDTO);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
