package com.tsswebapps.finance.controller.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ReceitaDto {
	private String descricao;
	private Double valor;
	private LocalDateTime dataLancamento;

	public ReceitaDto(String descricao, Double valor, LocalDateTime dataLancamento) {
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

	public LocalDateTime getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDateTime dataLancamento) {
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
