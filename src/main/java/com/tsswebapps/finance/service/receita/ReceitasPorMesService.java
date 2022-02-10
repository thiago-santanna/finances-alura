package com.tsswebapps.finance.service.receita;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.dto.ReceitaDto;
import com.tsswebapps.finance.model.Receita;
import com.tsswebapps.finance.repository.IReceitaRepository;
import com.tsswebapps.finance.service.user.BuscaUsuarioPorUserName;
import com.tsswebapps.finance.service.user.UsuarioLogado;

@Service
public class ReceitasPorMesService {

	@Autowired
	private IReceitaRepository repository;
	
	@Autowired
	private BuscaUsuarioPorUserName buscaUsuarioPorUserName;
	
	@Autowired
	private UsuarioLogado usuarioLogado;
	
	public List<ReceitaDto> execute(Integer ano, Integer mes){
		
		Long id = buscaUsuarioPorUserName.execute(usuarioLogado.execute()).getId();
		
		List<Receita> receitasPorMes = repository.findByPorMes(ano, mes);
		
		List<ReceitaDto> receitas = receitasPorMes.stream()
				.filter(desp -> desp.getUser().getId() == id)
				.map(rec -> rec.toReceitaDto())
				.collect(Collectors.toList());
		
		return receitas;
	}
}
