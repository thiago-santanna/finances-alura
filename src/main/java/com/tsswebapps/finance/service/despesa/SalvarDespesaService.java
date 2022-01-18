package com.tsswebapps.finance.service.despesa;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.tsswebapps.finance.exceptions.BadRequestException;
import com.tsswebapps.finance.model.Despesa;
import com.tsswebapps.finance.repository.IDespesaRepository;

@Service
public class SalvarDespesaService {

	@Autowired
	private IDespesaRepository despesaRepository;
	
	@Transactional
	public Despesa execute(Despesa despesa, BindingResult resultValidation) {
		if(resultValidation.hasErrors()) {
			throw new BadRequestException("Informe todos os campos obrigatórios.");
		}
		
		Despesa despesaSalva = despesaRepository.save(despesa);
		return despesaSalva;
	}
}
