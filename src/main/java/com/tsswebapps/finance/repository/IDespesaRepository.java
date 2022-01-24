package com.tsswebapps.finance.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsswebapps.finance.model.Despesa;

@Repository
public interface IDespesaRepository extends JpaRepository<Despesa, Long> {
	
	List<Despesa> findByDescricaoAndDataLancamento(String descricao, LocalDate dataLancamento);
	List<Despesa> findByDescricaoLike(String descricao);
}
