package com.tsswebapps.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsswebapps.finance.model.Despesa;

@Repository
public interface IDescpesaRepository extends JpaRepository<Despesa, Long> {

}
