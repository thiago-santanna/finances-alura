package com.tsswebapps.finance.dto;

import java.util.Objects;

public class ResumoCategoriaDto {
	private String categoria;
	private double total;

	public ResumoCategoriaDto(String categoria, double total) {
		super();
		this.categoria = categoria;
		this.total = total;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
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
		return Objects.equals(categoria, other.categoria)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}

	@Override
	public String toString() {
		return "ResumoCategoriaDto [categoria=" + categoria + ", total=" + total + "]";
	}

	public ResumoCategoriaDto() {
	}

}
