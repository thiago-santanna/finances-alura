package com.tsswebapps.finance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsswebapps.finance.model.User;

public interface IUsuarioRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String name);
}
