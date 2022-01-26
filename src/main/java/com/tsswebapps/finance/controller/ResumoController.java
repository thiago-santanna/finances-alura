package com.tsswebapps.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.finance.dto.ResumoDto;
import com.tsswebapps.finance.service.ResumoService;

@RestController
@RequestMapping("/resumo")
public class ResumoController {
	
	@Autowired
	private ResumoService resumo;

	@GetMapping("/{ano}/{mes}")
	public ResumoDto gerarResumo(@PathVariable String ano, @PathVariable String mes) {
		return resumo.execute(mes, ano);
	}
}
