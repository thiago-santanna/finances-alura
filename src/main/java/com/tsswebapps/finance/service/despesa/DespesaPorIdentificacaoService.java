package com.tsswebapps.finance.service.despesa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.exceptions.NotFoundException;
import com.tsswebapps.finance.model.Despesa;
import com.tsswebapps.finance.repository.IDespesaRepository;

@Service
public class DespesaPorIdentificacaoService {
	
	@Autowired
	private IDespesaRepository despesaRepository;
	
	public Despesa execute(Long id) {
		Optional<Despesa> optional = despesaRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new NotFoundException("Despesa não encontrada.");
		}
		
		return optional.get();
	}
}
