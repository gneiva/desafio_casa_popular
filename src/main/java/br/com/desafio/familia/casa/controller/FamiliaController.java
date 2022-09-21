package br.com.desafio.familia.casa.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.familia.casa.dto.FamiliaDTO;
import br.com.desafio.familia.casa.repository.FamiliaRepository;

@RestController
@RequestMapping("/familia")
public class FamiliaController {
	
	@Autowired
	private FamiliaRepository familiaRepository;
	
	@GetMapping("/rank")
	public ResponseEntity<Object> consultar() {
		try {
			
			List<FamiliaDTO> familiasDTO = 
					familiaRepository.findAll().stream()
					.filter(familia -> familia.getPessoas().size() > 0)
					.map(familia -> new FamiliaDTO(familia))
					.sorted(Comparator.comparingInt(FamiliaDTO::getPontos).reversed())
					.collect(Collectors.toList());
			
			if(familiasDTO.size() > 0) {
				return ResponseEntity.ok(familiasDTO);
			}
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
