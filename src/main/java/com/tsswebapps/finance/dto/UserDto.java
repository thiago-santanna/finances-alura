package com.tsswebapps.finance.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tsswebapps.finance.model.Perfil;
import com.tsswebapps.finance.model.User;

public class UserDto {
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	private Long id;

	public Long getId() {
		return id;
	}

	public UserDto(Long id, String nome, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	private String nome;
	private String email;
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String password) {
		this.senha = password;
	}

	public User toUser() {
		BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();

		User user = new User();

		Perfil perfilUsuario = new Perfil();
		perfilUsuario.setNome("USER");
		List<Perfil> perfis = new ArrayList<>();
		perfis.add(perfilUsuario);

		user.setPerfis(perfis);
		user.setNome(this.nome);
		user.setEmail(this.email);
		user.setSenha(bEncoder.encode(this.senha));

		return user;
	}
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
}
