package com.tsswebapps.finance.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.exceptions.NotFoundException;
import com.tsswebapps.finance.model.User;
import com.tsswebapps.finance.repository.IUsuarioRepository;

@Service
public class BuscaUsuarioPorUserName {
	
	@Autowired
	private IUsuarioRepository repository;
	
	public User execute(String userName) {
		Optional<User> user = repository.findByEmail(userName);
		return user.orElseThrow(NotFoundException::new);
	}
}
