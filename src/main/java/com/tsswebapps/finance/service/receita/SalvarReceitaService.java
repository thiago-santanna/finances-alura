package com.tsswebapps.finance.service.receita;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.tsswebapps.finance.exceptions.receita.ReceitaBadRequestException;
import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.repository.IReceitaRepository;

@Service
public class SalvarReceitaService {
	
	@Autowired
	private IReceitaRepository receitaRepository;
	
	@Transactional
	public Receita execute(Receita receita, BindingResult resultValidation) {
		if(resultValidation.hasErrors()) {
			throw new ReceitaBadRequestException("Informe todos os campos obrigatórios.");
		}
		
		Receita receitaSalva = receitaRepository.save(receita);
		return receitaSalva;
	}
}
