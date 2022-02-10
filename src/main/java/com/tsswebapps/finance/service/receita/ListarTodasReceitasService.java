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
public class ListarTodasReceitasService {
	
	@Autowired
	private IReceitaRepository receitaRepository;
	
	@Autowired
	private BuscaUsuarioPorUserName buscaUsuarioPorUserName;
	
	@Autowired
	private UsuarioLogado usuarioLogado;
	
	public List<ReceitaDto> execute(String descricao){
		List<Receita> receitas = null;
		
		Long id = buscaUsuarioPorUserName.execute(usuarioLogado.execute()).getId();
		
		receitas = descricao != null ? receitaRepository.findByDescricaoContaining(descricao)
				: receitaRepository.findAll();				
		
		List<ReceitaDto> receitasDto = receitas.stream()
				.filter(desp -> desp.getUser().getId() == id)
				.map(rec -> rec.toReceitaDto())
				.collect(Collectors.toList());
		
		return receitasDto;
	}
}
