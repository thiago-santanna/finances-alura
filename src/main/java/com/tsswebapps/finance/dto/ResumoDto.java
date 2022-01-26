package com.tsswebapps.finance.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ResumoDto {
	private Double totalReceitas;
	private Double totalDespesas;
	private Double saldo;
	private List<ResumoCategoriaDto> resumoCategoria = new ArrayList<>();

	public void addResumoCategoria(ResumoCategoriaDto resumoCategoriaDto) {
		this.resumoCategoria.add(resumoCategoriaDto);
	}

	public Double getTotalReceitas() {
		return totalReceitas;
	}

	public void setTotalReceitas(Double totalReceitas) {
		this.totalReceitas = totalReceitas;
	}

	public Double getTotalDespesas() {
		return totalDespesas;
	}

	public void setTotalDespesas(Double totalDespesas) {
		this.totalDespesas = totalDespesas;
	}

	public Double getSaldo() {
		return saldo;
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
		return Objects.equals(resumoCategoria, other.resumoCategoria) && Objects.equals(saldo, other.saldo)
				&& Objects.equals(totalDespesas, other.totalDespesas)
				&& Objects.equals(totalReceitas, other.totalReceitas);
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public List<ResumoCategoriaDto> getResumoCategoria() {
		return Collections.unmodifiableList(resumoCategoria);
	}

	@Override
	public String toString() {
		return "ResumoDto [totalReceitas=" + totalReceitas + ", totalDespesas=" + totalDespesas + ", saldo=" + saldo
				+ ", resumoCategoria=" + resumoCategoria + "]";
	}
}
