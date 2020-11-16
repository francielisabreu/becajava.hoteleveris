package br.hoteleveris.app.response;

public class QuartoResponse {

	private Long id;
	private int andar;
	private int numero;
	private String situacao;
	private Long tipoQuartoId;
	private Long comodidadeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getComodidadeId() {
		return comodidadeId;
	}

	public void setComodidadeId(Long comodidadeId) {
		this.comodidadeId = comodidadeId;
	}

}
