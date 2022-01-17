package com.tsswebapps.finance.service.receita;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.repository.IReceitaRepository;

@Service
public class ListarTodasReceitasService {
	
	@Autowired
	public IReceitaRepository receitaRepository;
	
	public List<Receita> execute(){
		return receitaRepository.findAll();
	}
}
