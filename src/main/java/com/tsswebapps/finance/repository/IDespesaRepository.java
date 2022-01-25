package com.tsswebapps.finance.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tsswebapps.finance.model.Despesa;

@Repository
public interface IDespesaRepository extends JpaRepository<Despesa, Long> {
	
	List<Despesa> findByDescricaoAndDataLancamento(String descricao, LocalDate dataLancamento);
	List<Despesa> findByDescricaoContaining(String descricao);	
	@Query(nativeQuery = true, value = "SELECT * FROM despesa WHERE EXTRACT(YEAR FROM data_lancamento ) = ?1 AND EXTRACT( MONTH FROM data_lancamento) = ?2")
	List<Despesa> findByPorMes(String ano, String mes);
}
