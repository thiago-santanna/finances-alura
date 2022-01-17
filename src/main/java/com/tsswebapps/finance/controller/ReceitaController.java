package com.tsswebapps.finance.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
	
	@PostMapping
	public void cadastroReceita(ReceitaDto receita) {
		
	}
}
