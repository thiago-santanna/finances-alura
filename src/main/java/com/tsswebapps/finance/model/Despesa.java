package com.tsswebapps.finance.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

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

	public Despesa() {
	}

	@Override
	public String toString() {
		return "Despesa [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", dataLancamento="
				+ dataLancamento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, createdAt, dataLancamento, descricao, id, updatedAt, user, valor);
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
		return categoria == other.categoria && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(dataLancamento, other.dataLancamento) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(updatedAt, other.updatedAt)
				&& Objects.equals(user, other.user) && Objects.equals(valor, other.valor);
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
