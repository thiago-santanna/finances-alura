package com.tsswebapps.finance.service.receita;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.exceptions.BadRequestException;
import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.repository.IReceitaRepository;

@Service
public class PesquisarReceitaDuplicadaMesService {
	@Autowired
	private IReceitaRepository receitaRepository;
	
	public void execute(String descricao, LocalDate dataLancamento) {
		List<Receita> temReceita = receitaRepository.findByDescricaoAndDataLancamento(
				descricao, dataLancamento);
		
		if(!temReceita.isEmpty()) {
			throw new BadRequestException("Receita já cadastrada esse mês.");
		}
	}
}
