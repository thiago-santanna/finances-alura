package com.tsswebapps.finance.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tsswebapps.finance.dto.DespesaDto;

@Entity
public class Despesa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 150)
	private String descricao;
	
	private Double valor;
	
	private LocalDate dataLancamento;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	private Categoria categoria;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void copyDespesaDto(DespesaDto despesaDto) {
		this.descricao = despesaDto.getDescricao();
		this.dataLancamento = despesaDto.getDataLancamento();
		this.valor = despesaDto.getValor();
		this.categoria = Categoria.valueOf(despesaDto.getCategoria());
	}

	public Despesa(String descricao, Double valor, LocalDate dataLancamento) {
		this.descricao = descricao;
		this.valor = valor;
		this.dataLancamento = dataLancamento;
		this.categoria = Categoria.valueOf("OUTRAS");
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
		return Objects.hash(categoria, dataLancamento, descricao, id, valor);
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
		return categoria == other.categoria && Objects.equals(dataLancamento, other.dataLancamento)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(valor, other.valor);
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

	public Long getId() {
		return id;
	}

	public DespesaDto toDespesaDto() {
		DespesaDto despesaDto = new DespesaDto();
		despesaDto.setDescricao(this.descricao);
		despesaDto.setDataLancamento(this.dataLancamento);
		despesaDto.setValor(this.valor);
		
		return despesaDto;
	}
}
