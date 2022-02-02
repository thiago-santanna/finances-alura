package com.tsswebapps.finance.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.dto.UserDto;
import com.tsswebapps.finance.model.User;
import com.tsswebapps.finance.repository.IUsuarioRepository;

@Service
public class CadastrarUsuarioService {
	
	@Autowired
	private IUsuarioRepository repository;
	
	public UserDto execute(UserDto usuario) {
		User user = usuario.toUser();
		repository.save(user);
		return usuario;
	}
}
