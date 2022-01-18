package com.tsswebapps.finance.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	public ResponseEntity<Receita> cadastro(@Valid @RequestBody ReceitaDto receitaDto, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);					
		}
		
		Boolean duplicada = duplicadaMes.execute(receitaDto.getDescricao(), receitaDto.getDataLancamento());
		
		if(duplicada) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Receita receita = salvarReceitaService.execute(receitaDto.toReceita());
		
		return new ResponseEntity<Receita>(receita, HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<ReceitaDto>> todas(){		
		List<ReceitaDto> receitasDto = listarTodasReceitas.execute();		
		return new ResponseEntity<List<ReceitaDto>>(receitasDto, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ReceitaDto> porId(@PathVariable Long id){	
		Optional<Receita> optionalReceita = receitaIdentificacao.execute(id);
		
		if(optionalReceita.isEmpty()) {
			return new ResponseEntity<ReceitaDto>(HttpStatus.NOT_FOUND);
		}
		Receita receita = optionalReceita.get();
		
		return new ResponseEntity<ReceitaDto>(receita.toReceitaDto(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReceitaDto> alterar(@PathVariable Long id, @Valid @RequestBody ReceitaDto receitaDto){
		Optional<Receita> optionalReceita = receitaIdentificacao.execute(id);
		
		if(optionalReceita.isEmpty()) {
			return new ResponseEntity<ReceitaDto>(HttpStatus.NOT_FOUND);
		}
		
		Receita receitaAtual = optionalReceita.get();
		receitaAtual.copyReceitaDto(receitaDto);
			
		Receita receitaSalva = salvarReceitaService.execute(receitaAtual);
		return new ResponseEntity<ReceitaDto>(receitaSalva.toReceitaDto(), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id){
		Optional<Receita> optionalReceita = receitaIdentificacao.execute(id);
		
		if(optionalReceita.isEmpty()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}	
		
		apagarReceita.execute(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
