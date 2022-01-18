package com.tsswebapps.finance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.finance.dto.DespesaDto;
import com.tsswebapps.finance.model.Despesa;
import com.tsswebapps.finance.service.despesa.PesquisarDespesaDuplicadaMesService;
import com.tsswebapps.finance.service.despesa.SalvarDespesaService;

@RestController
@RequestMapping("/despesas")
public class DespesaController {
	
	@Autowired
	private PesquisarDespesaDuplicadaMesService despesaDuplicadaMes;
	@Autowired
	private SalvarDespesaService salvarDespesa;
	
	@PostMapping
	public ResponseEntity<Despesa> salvar(@Valid @RequestBody DespesaDto despesaDto, BindingResult resultValidation) {
		despesaDuplicadaMes.execute(despesaDto.getDescricao(), despesaDto.getDataLancamento());
		
		Despesa despesa = salvarDespesa.execute(despesaDto.toDespesa(), resultValidation);
		
		return new ResponseEntity<Despesa>(despesa, HttpStatus.CREATED);
	}
}
