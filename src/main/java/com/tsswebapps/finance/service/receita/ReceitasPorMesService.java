package com.tsswebapps.finance.service.receita;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.dto.ReceitaDto;
import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.repository.IReceitaRepository;

@Service
public class ReceitasPorMesService {

	@Autowired
	private IReceitaRepository repository;
	
	public List<ReceitaDto> execute(Integer ano, Integer mes){
		List<Receita> receitasPorMes = repository.findByPorMes(ano, mes);
		
		List<ReceitaDto> receitas = receitasPorMes.stream()
				.map(rec -> rec.toReceitaDto())
				.collect(Collectors.toList());
		
		return receitas;
	}
}
