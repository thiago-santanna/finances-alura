package com.tsswebapps.finance.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.finance.dto.DespesaDto;
import com.tsswebapps.finance.exceptions.BadRequestException;
import com.tsswebapps.finance.model.Despesa;
import com.tsswebapps.finance.service.despesa.ApagarDespesaService;
import com.tsswebapps.finance.service.despesa.DespesaPorIdentificacaoService;
import com.tsswebapps.finance.service.despesa.ListarCategoriasService;
import com.tsswebapps.finance.service.despesa.ListasTodasDespesasService;
import com.tsswebapps.finance.service.despesa.PesquisarDespesaDuplicadaMesService;
import com.tsswebapps.finance.service.despesa.SalvarDespesaService;

@RestController
@RequestMapping("/despesas")
public class DespesaController {
	
	@Autowired
	private PesquisarDespesaDuplicadaMesService despesaDuplicadaMes;
	@Autowired
	private SalvarDespesaService salvarDespesa;
	@Autowired
	private ListasTodasDespesasService listarTodasDespesas;
	@Autowired
	private DespesaPorIdentificacaoService despesaPorIdentificacao;
	@Autowired
	private ApagarDespesaService apagarDespesa;
	@Autowired
	private ListarCategoriasService listarCategorias;
	
	@GetMapping("/categorias")
	public List<String> listaCategoria() {
		List<String> categorias = listarCategorias.execute();
		return categorias;
	}
	
	@PostMapping
	public ResponseEntity<Despesa> salvar(@Valid @RequestBody DespesaDto despesaDto, BindingResult resultValidation) {
		
		if(resultValidation.hasErrors()) {
			throw new BadRequestException("Informe todos os campos obrigatórios.");
		}
		
		despesaDuplicadaMes.execute(despesaDto.getDescricao(), despesaDto.getDataLancamento());
		Despesa despesa = salvarDespesa.execute(despesaDto.toDespesa());
		
		return new ResponseEntity<Despesa>(despesa, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<DespesaDto>> todas(@RequestParam(required = false, name = "descricao") String descricao){
		List<DespesaDto> despesas = listarTodasDespesas.execute(descricao);
		return new ResponseEntity<List<DespesaDto>>(despesas, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DespesaDto> porId(@PathVariable Long id){
		Despesa despesa = despesaPorIdentificacao.execute(id);
		return new ResponseEntity<DespesaDto>(despesa.toDespesaDto(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DespesaDto> alterar(@PathVariable Long id, 
			@Valid @RequestBody DespesaDto despesaDto, BindingResult resultValidation){
		
		if(resultValidation.hasErrors()) {
			throw new BadRequestException("Informe todos os campos obrigatórios.");
		}
		
		Despesa despesaAtual = despesaPorIdentificacao.execute(id);
		despesaAtual.copyDespesaDto(despesaDto);
			
		Despesa receitaSalva = salvarDespesa.execute(despesaAtual);
		return new ResponseEntity<DespesaDto>(receitaSalva.toDespesaDto(), HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id){
		despesaPorIdentificacao.execute(id);		
		apagarDespesa.execute(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
