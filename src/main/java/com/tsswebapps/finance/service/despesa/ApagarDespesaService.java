package com.tsswebapps.finance.service.despesa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.repository.IDespesaRepository;

@Service
public class ApagarDespesaService {
	
	@Autowired
	private IDespesaRepository despesaRepository;
	
	public void execute(Long id) {
		despesaRepository.deleteById(id);
	}
}
