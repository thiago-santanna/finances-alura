package com.tsswebapps.finance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.finance.dto.UserDto;
import com.tsswebapps.finance.repository.IUsuarioRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	private IUsuarioRepository repository;
	
	@PostMapping
	public ResponseEntity<String> cadastrar(@RequestBody UserDto user){
		return new ResponseEntity<String>("Cadastrado", HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Void> login(@RequestBody UserDto user){
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
