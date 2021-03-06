package br.hoteleveris.app.response;

import java.sql.Date;

public class OcupacaoResponse {

	private Long id;
	private int qntDiaria;
	private Date data;
	private String situacao;
	private Long clienteId;
	private Long quartoId;

	
	public OcupacaoResponse(Long id, int qntDiaria, Date data, String situacao, Long clienteId, Long quartoId) {
		super();
		this.id = id;
		this.qntDiaria = qntDiaria;
		this.data = data;
		this.situacao = situacao;
		this.clienteId = clienteId;
		this.quartoId = quartoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQntDiaria() {
		return qntDiaria;
	}

	public void setQntDiaria(int qntDiaria) {
		this.qntDiaria = qntDiaria;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getQuartoId() {
		return quartoId;
	}

	public void setQuartoId(Long quartoId) {
		this.quartoId = quartoId;
	}

}
