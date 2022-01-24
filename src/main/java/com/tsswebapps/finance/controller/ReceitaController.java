package com.tsswebapps.finance.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.finance.dto.ReceitaDto;
import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.service.receita.ApagarReceitaService;
import com.tsswebapps.finance.service.receita.ListarTodasReceitasService;
import com.tsswebapps.finance.service.receita.PesquisarReceitaDuplicadaMesService;
import com.tsswebapps.finance.service.receita.ReceitaPorIdentificacaoService;
import com.tsswebapps.finance.service.receita.SalvarReceitaService;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
	
	public static final Logger log = LoggerFactory.getLogger(ReceitaController.class);
		
	@Autowired
	private PesquisarReceitaDuplicadaMesService duplicadaMes;
	@Autowired
	private SalvarReceitaService salvarReceitaService;
	@Autowired
	private ListarTodasReceitasService listarTodasReceitas;
	@Autowired
	private ReceitaPorIdentificacaoService receitaIdentificacao;
	@Autowired
	private ApagarReceitaService apagarReceita;
	
	@PostMapping
	public ResponseEntity<Receita> cadastro(@Valid @RequestBody ReceitaDto receitaDto, BindingResult resultValidation) {
		duplicadaMes.execute(receitaDto.getDescricao(), receitaDto.getDataLancamento());		
		
		Receita receita = salvarReceitaService.execute(receitaDto.toReceita(), resultValidation);
		
		log.info("Receita cadastrada - > ID: " + receita.getId());
		
		return new ResponseEntity<Receita>(receita, HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<ReceitaDto>> todas(@RequestParam(required = false, name = "descricao") String descricao){		
		List<ReceitaDto> receitasDto = listarTodasReceitas.execute(descricao);		
		return new ResponseEntity<List<ReceitaDto>>(receitasDto, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ReceitaDto> porId(@PathVariable Long id){
		Receita receita = receitaIdentificacao.execute(id);
		return new ResponseEntity<ReceitaDto>(receita.toReceitaDto(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReceitaDto> alterar(@PathVariable Long id, 
			@Valid @RequestBody ReceitaDto receitaDto, BindingResult resultValidation){
		
		Receita receitaAtual = receitaIdentificacao.execute(id);
		receitaAtual.copyReceitaDto(receitaDto);
			
		Receita receitaSalva = salvarReceitaService.execute(receitaAtual, resultValidation);
		return new ResponseEntity<ReceitaDto>(receitaSalva.toReceitaDto(), HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id){
		receitaIdentificacao.execute(id);		
		apagarReceita.execute(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
