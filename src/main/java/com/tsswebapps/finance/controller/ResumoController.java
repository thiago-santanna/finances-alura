package com.tsswebapps.finance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resumo")
public class ResumoController {

	@GetMapping
	public void gerarResumo(@PathVariable String ano, @PathVariable String mes) {
		
	}
}
