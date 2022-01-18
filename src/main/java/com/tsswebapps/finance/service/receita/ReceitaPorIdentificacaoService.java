package com.tsswebapps.finance.service.receita;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.repository.IReceitaRepository;

@Service
public class ReceitaPorIdentificacaoService {
	@Autowired
	private IReceitaRepository receitaRepository;
	
	public Optional<Receita> execute(Long id) {
		return receitaRepository.findById(id);
	}
}
