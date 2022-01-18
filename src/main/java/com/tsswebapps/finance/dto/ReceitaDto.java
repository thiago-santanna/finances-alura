package com.tsswebapps.finance.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsswebapps.finance.model.Receita;

public class ReceitaDto {
	@NotBlank
	private String descricao;
	@NotNull
	private Double valor;
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataLancamento;

	public Receita toReceita() {
		Receita receita = new Receita();
		receita.setDescricao(this.descricao);
		receita.setDataLancamento(this.dataLancamento);
		receita.setValor(this.valor);

		return receita;
	}

	public ReceitaDto(String descricao, Double valor, LocalDate dataLancamento) {
		this.descricao = descricao;
		this.valor = valor;
		this.dataLancamento = dataLancamento;
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

	@Override
	public int hashCode() {
		return Objects.hash(dataLancamento, descricao, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReceitaDto other = (ReceitaDto) obj;
		return Objects.equals(dataLancamento, other.dataLancamento) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(valor, other.valor);
	}

	@Override
	public String toString() {
		return "ReceitaDto [descricao=" + descricao + ", valor=" + valor + ", dataLancamento=" + dataLancamento + "]";
	}

}
