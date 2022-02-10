package com.tsswebapps.finance.service.despesa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.dto.DespesaDto;
import com.tsswebapps.finance.model.Despesa;
import com.tsswebapps.finance.repository.IDespesaRepository;
import com.tsswebapps.finance.service.user.BuscaUsuarioPorUserName;
import com.tsswebapps.finance.service.user.UsuarioLogado;

@Service
public class DespesasPorMesService {
	@Autowired
	private IDespesaRepository repository;
	
	@Autowired
	private BuscaUsuarioPorUserName buscaUsuarioPorUserName;
	
	@Autowired
	private UsuarioLogado usuarioLogado;	
	
	public List<DespesaDto> execute(String ano, String mes){
		
		Long id = buscaUsuarioPorUserName.execute(usuarioLogado.execute()).getId();
		
		List<Despesa> despesasPorMes = repository.findByPorMes(ano, mes);
		
		List<DespesaDto> despesas = despesasPorMes.stream()
				.filter(desp -> desp.getUser().getId() == id)
				.map(desp -> desp.toDespesaDto())
				.collect(Collectors.toList());
		
		return despesas;
	}
}
