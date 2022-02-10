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
public class ListasTodasDespesasService {

	@Autowired
	private IDespesaRepository despesaRepository;

	@Autowired
	private BuscaUsuarioPorUserName buscaUsuarioPorUserName;
	
	@Autowired
	private UsuarioLogado usuarioLogado;
	
	public List<DespesaDto> execute(String descricao) {
		List<Despesa> despesas = null;
	
		Long id = buscaUsuarioPorUserName.execute(usuarioLogado.execute()).getId();
		
		despesas = descricao != null ? despesaRepository.findByDescricaoContaining(descricao)
				: despesaRepository.findAll();

		List<DespesaDto> despesaDto = despesas.stream()
				.filter(desp -> desp.getUser().getId() == id) //Isso nao sera performatico a longo prazo, mas pra esse projeto vai assim mesmo, o ideal seria fazer uma consulta personalizada no repositprio.
				.map(desp -> desp.toDespesaDto())
				.collect(Collectors.toList());

		return despesaDto;
	}
}
