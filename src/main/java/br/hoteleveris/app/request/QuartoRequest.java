package br.hoteleveris.app.request;

import java.util.List;

public class QuartoRequest {

	private int andar;
	private int numero;
	private String situacao;
	private Long tipoQuartoId;

	private List<ComodidadeRequest> Comodidade;

	public List<ComodidadeRequest> getComodidade() {
		return Comodidade;
	}

	public void setComodidade(List<ComodidadeRequest> comodidade) {
		Comodidade = comodidade;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Long getTipoQuartoId() {
		return tipoQuartoId;
	}

	public void setTipoQuartoId(Long tipoQuartoId) {
		this.tipoQuartoId = tipoQuartoId;
	}

}
