package com.tsswebapps.finance.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsswebapps.finance.exceptions.BadRequestException;
import com.tsswebapps.finance.model.Categoria;
import com.tsswebapps.finance.model.Despesa;
import com.tsswebapps.finance.model.User;

public class DespesaDto {
	@NotBlank
	private String descricao;
	@NotNull
	private Double valor;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataLancamento;

	private String categoria;

	private Long userId;
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Despesa toDespesa(User user) {
		if ((!this.categoria.isBlank() && findEnumByName(this.categoria) == null)) {
			throw new BadRequestException("Informe uma categoria válida, veja em: /despesas/categorias");
		}

		Categoria cat = this.categoria.isBlank() ? Categoria.OUTRAS : Categoria.valueOf(this.categoria.toUpperCase());

		Despesa despesa = new Despesa();
		despesa.setDescricao(this.descricao);
		despesa.setDataLancamento(this.dataLancamento);
		despesa.setValor(this.valor);
		despesa.setCategoria(cat);
		despesa.setUser(user);
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

	@Override
	public int hashCode() {
		return Objects.hash(categoria, dataLancamento, descricao, userId, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DespesaDto other = (DespesaDto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(dataLancamento, other.dataLancamento)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(userId, other.userId)
				&& Objects.equals(valor, other.valor);
	}

	@Override
	public String toString() {
		return "DespesaDto [descricao=" + descricao + ", valor=" + valor + ", dataLancamento=" + dataLancamento
				+ ", categoria=" + categoria + ", userId=" + userId + "]";
	}
}
