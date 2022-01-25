package com.tsswebapps.finance.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tsswebapps.finance.model.Receita;

@Repository
public interface IReceitaRepository extends JpaRepository<Receita, Long> {
	
	List<Receita> findByDescricaoAndDataLancamento(String descricao, LocalDate dataLancamento);
	List<Receita> findByDescricaoContaining(String descricao);	
	@Query(nativeQuery = true, value = "SELECT * FROM receita WHERE EXTRACT(YEAR FROM data_lancamento ) = ?1 AND EXTRACT( MONTH FROM data_lancamento) = ?2")
	List<Receita> findByPorMes(String ano, String mes);

}
