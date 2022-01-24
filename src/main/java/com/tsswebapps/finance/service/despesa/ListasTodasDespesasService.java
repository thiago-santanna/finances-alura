package com.tsswebapps.finance.service.despesa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.dto.DespesaDto;
import com.tsswebapps.finance.model.Despesa;
import com.tsswebapps.finance.repository.IDespesaRepository;

@Service
public class ListasTodasDespesasService {
	
	@Autowired
	private IDespesaRepository despesaRepository;
	
	public List<DespesaDto> execute(String descricao){
		List<Despesa> despesas = null;
		
		if(descricao != null) {
			despesas = despesaRepository.findByDescricaoContaining(descricao);
		}
		else
		{
			despesas = despesaRepository.findAll();
		}
		
		List<DespesaDto> despesaDto = despesas.stream()
				.map(desp -> desp.toDespesaDto())
				.collect(Collectors.toList());
		
		return despesaDto;
	}
}
