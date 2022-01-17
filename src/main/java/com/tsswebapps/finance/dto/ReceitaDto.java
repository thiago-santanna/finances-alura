package com.tsswebapps.finance.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.tsswebapps.finance.model.Receita;


public class ReceitaDto {
	@NotBlank
	private String descricao;
	@NotBlank
	private Double valor;
	@NotBlank
	private LocalDateTime dataLancamento;
	
	public Receita toReceita() {
		Receita receita = new Receita();
		receita.setDescricao(this.descricao);
		receita.setDataLancamento(this.dataLancamento);
		receita.setValor(this.valor);
		
		return receita;
	}

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
