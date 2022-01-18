package com.tsswebapps.finance.exceptions;

import java.util.Date;

public class NegocioExceptionDto {

	private int status;
	private String mensagem;
	private Date data;

	public NegocioExceptionDto(int status, String mensagem, Date data) {
		this.status = status;
		this.mensagem = mensagem;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date dataOcorrido) {
		this.data = dataOcorrido;
	}

}
