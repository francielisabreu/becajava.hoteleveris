package br.hoteleveris.app.request;

public class TransferenciaRequest {

	public String hashOrigem;
	public String hashDestino;
	public double valor;

	public String getHashOrigem() {
		return hashOrigem;
	}
	
	public TransferenciaRequest() {}

	public void setHashOrigem(String hashOrigem) {
		this.hashOrigem = hashOrigem;
	}

	public String getHashDestino() {
		return hashDestino;
	}

	public void setHashDestino(String hashDestino) {
		this.hashDestino = hashDestino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
