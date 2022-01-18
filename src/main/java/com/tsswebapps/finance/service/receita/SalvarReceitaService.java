package com.tsswebapps.finance.service.receita;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.repository.IReceitaRepository;

@Service
public class SalvarReceitaService {
	
	@Autowired
	private IReceitaRepository receitaRepository;
	
	@Transactional
	public Receita execute(Receita receita) {
		Receita receitaSalva = receitaRepository.save(receita);
		return receitaSalva;
	}
}
