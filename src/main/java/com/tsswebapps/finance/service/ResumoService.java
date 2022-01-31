package com.tsswebapps.finance.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.dto.ResumoCategoriaDto;
import com.tsswebapps.finance.dto.ResumoDto;
import com.tsswebapps.finance.model.Despesa;
import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.repository.IDespesaRepository;
import com.tsswebapps.finance.repository.IReceitaRepository;
import com.tsswebapps.finance.service.despesa.ListarCategoriasService;

@Service
public class ResumoService {

	@Autowired
	private IReceitaRepository receitaRepository;

	@Autowired
	private IDespesaRepository despesaRepository;

	@Autowired
	private ListarCategoriasService listarCategorias;

	public ResumoDto execute(String mes, String ano) {
		
		List<Receita> receitasByPorMes = receitaRepository.findByPorMes(Integer.valueOf(ano), Integer.valueOf(mes));	
		Double totalReceitas = receitasByPorMes.stream()
				.reduce(0d, (total, receita) -> total + receita.getValor(), Double::sum);	
		
		List<Despesa> despesasByPorMes = despesaRepository.findByPorMes(ano, mes);		
		Double totalDespesas = despesasByPorMes.stream()
				.reduce(0d, (total, despesa) -> total + despesa.getValor(), Double::sum );
		
		Double saldoFinalMes = totalReceitas - totalDespesas;
		
		List<String> categorias = listarCategorias.execute();
				
		List<ResumoCategoriaDto> resumoCategoriaDto = categorias.stream()
				.map(cat -> new ResumoCategoriaDto(cat, despesaRepository.resumoPorCategoria(ano, mes, cat)))
				.collect(Collectors.toList());	
		
		ResumoDto resumoDto = new ResumoDto();
		resumoDto.setTotalDespesas(totalDespesas);
		resumoDto.setTotalReceitas(totalReceitas);
		resumoDto.setSaldo(saldoFinalMes);
		
		for (ResumoCategoriaDto resumo : resumoCategoriaDto) {
			resumoDto.addResumoCategoria(resumo);
		}
		
		return resumoDto;
	}

}
