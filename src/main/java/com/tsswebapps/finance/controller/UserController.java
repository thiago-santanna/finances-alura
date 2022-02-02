package com.tsswebapps.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.finance.dto.UserDto;
import com.tsswebapps.finance.service.user.CadastrarUsuarioService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private CadastrarUsuarioService service;
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody UserDto user){		
		service.execute(user);		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
