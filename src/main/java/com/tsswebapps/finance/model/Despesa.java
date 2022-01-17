package com.tsswebapps.finance.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Despesa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 150)
	private String descricao;
	
	private Double valor;
	
	private LocalDateTime dataLancamento;

	public Despesa(String descricao, Double valor, LocalDateTime dataLancamento) {
		this.descricao = descricao;
		this.valor = valor;
		this.dataLancamento = dataLancamento;
	}

	public Despesa() {
	}

	@Override
	public String toString() {
		return "Despesa [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", dataLancamento="
				+ dataLancamento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataLancamento, descricao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesa other = (Despesa) obj;
		return Objects.equals(dataLancamento, other.dataLancamento) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id);
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

	public Long getId() {
		return id;
	}
}
