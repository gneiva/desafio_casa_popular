package br.com.desafio.familia.casa.service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.familia.casa.dto.FamiliaDTO;
import br.com.desafio.familia.casa.dto.PessoaDTO;
import br.com.desafio.familia.casa.enums.FaixaDeRendaEnum;
import br.com.desafio.familia.casa.enums.QuantidadeDependentesEnum;
import br.com.desafio.familia.casa.model.Familia;
import br.com.desafio.familia.casa.repository.FamiliaRepository;

@Service
public class FamiliaService {

	private final Integer IDADE_MAXIMA_DEPENDENTES = 18;

	@Autowired
	private FamiliaRepository familiaRepository;

	public List<FamiliaDTO> getListaOrdenada() {
		return getListaOrdenada(familiaRepository.findAll());
	}

	private List<FamiliaDTO> getListaOrdenada(List<Familia> familias) {
		return familias.stream()
				.filter(familia -> familia.getPessoas().size() > 0)
				.map(familia -> calcularPontos(familia))
				.sorted(Comparator.comparingInt(FamiliaDTO::getPontos).reversed())
				.collect(Collectors.toList());
	}

	private FamiliaDTO calcularPontos(Familia familia) {
		FamiliaDTO familiaDTO = new FamiliaDTO(familia);

		montarListaDependentes(familiaDTO);
		calculaRenda(familiaDTO);
		calcularPontosPorDependentes(familiaDTO);
		calcularPontosPorRenda(familiaDTO);

		return familiaDTO;
	}

	private void montarListaDependentes(FamiliaDTO familiaDTO) {

		List<PessoaDTO> dependentes = familiaDTO.getPessoas().stream()
				.filter(pessoa -> pessoa.getIdade() < IDADE_MAXIMA_DEPENDENTES)
				.collect(Collectors.toList());

		familiaDTO.setDependentes(dependentes);
	}
	
	private void calculaRenda(FamiliaDTO familiaDTO) {
		
		BigDecimal renda = BigDecimal.ZERO;
		for (PessoaDTO pessoaDTO : familiaDTO.getPessoas()) {
			renda = renda.add(pessoaDTO.getRenda());
		}
		familiaDTO.setRenda(renda);		
	}

	private void calcularPontosPorDependentes(FamiliaDTO familiaDTO) {

		Integer pontos = familiaDTO.getPontos();
		pontos += QuantidadeDependentesEnum
				.getPorQuantidadeDependentes(familiaDTO.getDependentes().size()).getPontos();
		familiaDTO.setPontos(pontos);
	}

	private void calcularPontosPorRenda(FamiliaDTO familiaDTO) {
		
		Integer pontos = familiaDTO.getPontos();
		pontos += FaixaDeRendaEnum.getPorRenda(familiaDTO.getRenda()).getPontos();
		familiaDTO.setPontos(pontos);
	}


}
