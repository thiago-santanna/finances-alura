package com.tsswebapps.finance.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsswebapps.finance.model.Receita;

@Repository
public interface IReceitaRepository extends JpaRepository<Receita, Long> {
	
	List<Receita> findByDescricaoAndDataLancamento(String descricao, LocalDateTime dataLancamento);

}
