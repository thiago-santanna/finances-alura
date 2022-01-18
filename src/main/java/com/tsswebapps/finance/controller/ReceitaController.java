package com.tsswebapps.finance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.finance.dto.ReceitaDto;
import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.service.receita.ListarTodasReceitasService;
import com.tsswebapps.finance.service.receita.PesquisarReceitaDuplicadaMesService;
import com.tsswebapps.finance.service.receita.SalvarReceitaService;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
	
	@Autowired
	public PesquisarReceitaDuplicadaMesService duplicadaMes;
	@Autowired
	public SalvarReceitaService receitaService;
	@Autowired
	public ListarTodasReceitasService listarTodasReceitas;
	
	@PostMapping
	public ResponseEntity<Receita> cadastro(@Valid @RequestBody ReceitaDto receitaDto, BindingResult result) {
		System.out.println("pass 1");
		
		if(result.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);					
		}
		
		Boolean duplicada = duplicadaMes.execute(receitaDto.getDescricao(), receitaDto.getDataLancamento());
		
		if(duplicada) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Receita receita = receitaService.execute(receitaDto.toReceita());
		
		return new ResponseEntity<Receita>(receita, HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<Receita>> todas(){
		
		List<Receita> receitas = listarTodasReceitas.execute();
		
		return new ResponseEntity<List<Receita>>(receitas, HttpStatus.OK);
	}
}
