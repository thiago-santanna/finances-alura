package com.tsswebapps.finance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsswebapps.finance.model.User;

@Repository
public interface IUsuarioRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
}
