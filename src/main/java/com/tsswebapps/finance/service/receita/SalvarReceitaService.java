package com.tsswebapps.finance.service.receita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.repository.IReceitaRepository;

@Service
public class SalvarReceitaService {
	
	@Autowired
	public IReceitaRepository receitaRepository;
	
	public Receita execute(Receita receita) {			
		Receita receitaSalva = receitaRepository.save(receita);
		return receitaSalva;
	}
}
