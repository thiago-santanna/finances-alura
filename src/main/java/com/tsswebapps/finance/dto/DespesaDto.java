package com.tsswebapps.finance.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsswebapps.finance.exceptions.BadRequestException;
import com.tsswebapps.finance.model.Categoria;
import com.tsswebapps.finance.model.Despesa;

public class DespesaDto {
	@NotBlank
	private String descricao;
	@NotNull
	private Double valor;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataLancamento;

	private String categoria;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Despesa toDespesa() {
		if(findEnumByName(this.categoria) == null) {
			throw new BadRequestException("Informe uma categoria válida, veja em: /despesas/categorias");
		}
		
		Categoria cat = this.categoria.isBlank() ? Categoria.OUTRAS : Categoria.valueOf(this.categoria.toUpperCase());
		
		Despesa despesa = new Despesa();
		despesa.setDescricao(this.descricao);
		despesa.setDataLancamento(this.dataLancamento);
		despesa.setValor(this.valor);
		despesa.setCategoria(cat);
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

	public DespesaDto(@NotBlank String descricao, @NotNull Double valor, @NotNull LocalDate dataLancamento,
			String categoria) {

		this.descricao = descricao;
		this.valor = valor;
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
	}

	public DespesaDto() {
	}

	public static Categoria findEnumByName(String name) {
		Categoria result = null;
		for (Categoria cat : Categoria.values()) {
			if (cat.name().equalsIgnoreCase(name)) {
				result = cat;
				break;
			}
		}
		return result;
	}
}
