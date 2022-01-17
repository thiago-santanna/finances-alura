package com.tsswebapps.finance.service.receita;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.repository.IReceitaRepository;

@Service
public class PesquisarReceitaDuplicadaMesService {
	public IReceitaRepository receitaRepository;
	
	public Boolean excute(String descricao, LocalDateTime dataLancamento) {
		List<Receita> temReceita = receitaRepository.findByDescricaoAndDataLancamento(
				descricao, dataLancamento);
		
		return !temReceita.isEmpty();
	}
}
