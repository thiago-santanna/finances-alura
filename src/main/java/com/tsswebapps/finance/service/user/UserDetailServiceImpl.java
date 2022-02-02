package com.tsswebapps.finance.service.user;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.model.User;
import com.tsswebapps.finance.repository.IUsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	private IUsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> usuario = repository.findByEmail(username);
		
		if (usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException("Usuario ou senha inválidos.");
	}
}
