package com.tsswebapps.finance.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsswebapps.finance.model.Despesa;

public class DespesaDto {
	@NotBlank
	private String descricao;
	@NotNull
	private Double valor;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataLancamento;
	
	public Despesa toDespesa() {
		Despesa despesa = new Despesa();
		despesa.setDescricao(this.descricao);
		despesa.setDataLancamento(this.dataLancamento);
		despesa.setValor(this.valor);
		
		return despesa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public DespesaDto(@NotBlank String descricao, @NotNull Double valor, @NotNull LocalDate dataLancamento) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.dataLancamento = dataLancamento;
	}

	public DespesaDto() {
	}
}
