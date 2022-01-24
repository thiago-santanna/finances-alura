package com.tsswebapps.finance.service.receita;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.dto.ReceitaDto;
import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.repository.IReceitaRepository;

@Service
public class ListarTodasReceitasService {
	
	@Autowired
	private IReceitaRepository receitaRepository;
	
	public List<ReceitaDto> execute(String descricao){
		List<Receita> receitas = null;
		
		if(descricao != null) {
			receitas = receitaRepository.findByDescricaoContaining(descricao);
		}
		else{
			receitas = receitaRepository.findAll();
		}				
		
		List<ReceitaDto> receitasDto = receitas.stream()
				.map(rec -> rec.toReceitaDto())
				.collect(Collectors.toList());
		
		return receitasDto;
	}
}
