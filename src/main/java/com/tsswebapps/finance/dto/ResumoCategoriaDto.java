package com.tsswebapps.finance.dto;

import java.util.Objects;

public class ResumoCategoriaDto {

	private String categoria;
	private Double total;

	@Override
	public String toString() {
		return "ResumoCategoriaDto [categoria=" + categoria + ", total=" + total + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResumoCategoriaDto other = (ResumoCategoriaDto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(total, other.total);
	}

	public ResumoCategoriaDto(String categoria, Double total) {
		this.categoria = categoria;
		this.total = total != null ? total : 0d;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
