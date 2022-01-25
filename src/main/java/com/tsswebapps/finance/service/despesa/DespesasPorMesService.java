package com.tsswebapps.finance.service.despesa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.dto.DespesaDto;
import com.tsswebapps.finance.model.Despesa;
import com.tsswebapps.finance.repository.IDespesaRepository;

@Service
public class DespesasPorMesService {
	@Autowired
	private IDespesaRepository repository;
	
	public List<DespesaDto> execute(String ano, String mes){
		List<Despesa> despesasPorMes = repository.findByPorMes(ano, mes);
		List<DespesaDto> despesas = despesasPorMes.stream()
				.map(desp -> desp.toDespesaDto())
				.collect(Collectors.toList());
		return despesas;
	}
}
