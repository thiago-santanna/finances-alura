package com.tsswebapps.finance.service.receita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.repository.IReceitaRepository;

@Service
public class ApagarReceitaService {
	
	@Autowired
	private IReceitaRepository receitaRepository;
	
	public void execute(Long id) {
		receitaRepository.deleteById(id);
	}
}
