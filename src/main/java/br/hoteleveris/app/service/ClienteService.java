package br.hoteleveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;

@Service
public class ClienteService {

	@Autowired
	final ClienteRepository _repository;

	public ClienteService(ClienteRepository repository) {
		_repository = repository;
	}

	public BaseResponse incluir(ClienteRequest request) {
		Cliente cliente = new Cliente();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getNome().isEmpty()) {
			response.message = "O campo nome precisa ser preenchido";
			return response;
		}

		if (request.getCpf().isEmpty()) {
			response.message = " O campo cpf precisa ser preenchido";
			return response;

		}

		if (request.getHash().isEmpty()) {
			response.message = "o campo hash precisa ser preenchido";
			return response;
		}

		cliente.setCpf(request.getCpf());

		cliente.setHash(request.getHash());

		cliente.setNome(request.getNome());

		_repository.save(cliente);

		response.message = "Cliente foi incluido com sucesso";
		response.statusCode = 201;
		return response;
	}

	public ClienteResponse Obter(Long id) {
		Optional<Cliente> cliente = _repository.findById(id);
		ClienteResponse response = new ClienteResponse();

		if (cliente.isEmpty()) {

			response.message = "Não foi possivel encontrar o cliente, inserida um valor válido";
			response.statusCode = 400;

			return response;
		}

		response.setNome(cliente.get().getNome());
		response.setCpf(cliente.get().getCpf());

		response.message = "Cliente obtido com sucesso!";
		response.statusCode = 200;
		return response;

	}

}
