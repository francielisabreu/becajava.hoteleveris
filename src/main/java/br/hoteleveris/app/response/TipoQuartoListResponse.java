package br.hoteleveris.app.response;

import java.util.List;

import br.hoteleveris.app.model.TipoQuarto;

public class TipoQuartoListResponse {

	private List<TipoQuarto> tipoquarto;

	public List<TipoQuarto> getTipoquarto() {
		return tipoquarto;
	}

	public void setTipoquarto(List<TipoQuarto> tipoquarto) {
		this.tipoquarto = tipoquarto;
	}

}
