package com.tsswebapps.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsswebapps.finance.model.Receita;

@Repository
public interface IReceitaRepository extends JpaRepository<Receita, Long> {

}
