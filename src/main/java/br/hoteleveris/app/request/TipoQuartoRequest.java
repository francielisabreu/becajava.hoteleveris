package br.hoteleveris.app.request;

public class TipoQuartoRequest {

	private Long id;
	private Double valor;
	private String descricao;

	public TipoQuartoRequest() {

	}

	public TipoQuartoRequest(Long id) {
		super();
		this.id = id;

	}

	public TipoQuartoRequest(Long id, Double valor, String descricao) {
		super();
		this.id = id;
		this.valor = valor;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
