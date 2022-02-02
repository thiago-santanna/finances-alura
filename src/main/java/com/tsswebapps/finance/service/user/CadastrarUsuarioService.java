package com.tsswebapps.finance.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.dto.UserDto;
import com.tsswebapps.finance.model.Perfil;
import com.tsswebapps.finance.model.User;
import com.tsswebapps.finance.repository.IUsuarioRepository;

@Service
public class CadastrarUsuarioService {
	
	@Autowired
	private IUsuarioRepository repository;
	
	public UserDto execute(UserDto usuario) {
		User user = usuario.toUser();
		
		Perfil perfilUsuario = new Perfil();
		perfilUsuario.setNome("USER");
		
		List<Perfil> perfis = new ArrayList<>();
		
		perfis.add(perfilUsuario);
		user.setPerfis(perfis);		
		
		
		repository.save(user);
		return usuario;
	}
}
