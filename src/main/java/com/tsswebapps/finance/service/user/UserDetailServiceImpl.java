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
		Optional<User> userByName = repository.findByUserName(username);
		
		userByName.orElseThrow( () -> new UsernameNotFoundException(username + " not found."));
		
		return userByName.map(UserDetailImpl::new).get();
	}

}
