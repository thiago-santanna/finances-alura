package com.tsswebapps.finance.dto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ResumoDto {
	private double totalReceitas;
	private double totalDespesas;
	private double saldo;
	private List<ResumoCategoriaDto> resumoCategoria;

	public void addResumoCategoria(ResumoCategoriaDto resumoCategoriaDto) {
		this.resumoCategoria.add(resumoCategoriaDto);
	}

	public double getTotalReceitas() {
		return totalReceitas;
	}

	public void setTotalReceitas(double totalReceitas) {
		this.totalReceitas = totalReceitas;
	}

	public double getTotalDespesas() {
		return totalDespesas;
	}

	public void setTotalDespesas(double totalDespesas) {
		this.totalDespesas = totalDespesas;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<ResumoCategoriaDto> getResumoCategoria() {
		return Collections.unmodifiableList(resumoCategoria);
	}

	@Override
	public int hashCode() {
		return Objects.hash(resumoCategoria, saldo, totalDespesas, totalReceitas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResumoDto other = (ResumoDto) obj;
		return Objects.equals(resumoCategoria, other.resumoCategoria)
				&& Double.doubleToLongBits(saldo) == Double.doubleToLongBits(other.saldo)
				&& Double.doubleToLongBits(totalDespesas) == Double.doubleToLongBits(other.totalDespesas)
				&& Double.doubleToLongBits(totalReceitas) == Double.doubleToLongBits(other.totalReceitas);
	}

	@Override
	public String toString() {
		return "ResumoDto [totalReceitas=" + totalReceitas + ", totalDespesas=" + totalDespesas + ", saldo=" + saldo
				+ ", resumoCategoria=" + resumoCategoria + "]";
	}
}
