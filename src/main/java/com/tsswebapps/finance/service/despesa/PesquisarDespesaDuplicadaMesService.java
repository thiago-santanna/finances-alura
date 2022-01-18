package com.tsswebapps.finance.service.despesa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.exceptions.BadRequestException;
import com.tsswebapps.finance.model.Despesa;
import com.tsswebapps.finance.repository.IDespesaRepository;

@Service
public class PesquisarDespesaDuplicadaMesService {
	
	@Autowired
	private IDespesaRepository despesaRepository;
	
	public void execute(String descricao, LocalDate dataLancamento) {
		List<Despesa> temDespesas = despesaRepository.findByDescricaoAndDataLancamento(descricao, dataLancamento);
		
		if(!temDespesas.isEmpty()) {
			throw new BadRequestException("Despesa já cadastrada esse mês.");
		}		
	}
}
