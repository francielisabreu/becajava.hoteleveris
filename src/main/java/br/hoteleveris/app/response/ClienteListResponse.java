package br.hoteleveris.app.response;

import java.util.List;

import br.hoteleveris.app.model.Cliente;

public class ClienteListResponse extends BaseResponse {

	private List<Cliente> Clientes;

	public List<Cliente> getClientes() {
		return Clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.Clientes = clientes;
	}

}