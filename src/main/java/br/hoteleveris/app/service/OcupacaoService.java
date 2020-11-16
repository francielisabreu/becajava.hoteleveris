package br.hoteleveris.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.OcupacaoListResponse;

@Service
public class OcupacaoService {

	@Autowired
	final OcupacaoRepository _repository;

	public OcupacaoService(OcupacaoRepository repository) {
		_repository = repository;

	}

	public BaseResponse incluir(OcupacaoRequest request) {
		Ocupacao ocupation = new Ocupacao();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getClienteId() == null || request.getClienteId() <= 0) {
			response.message = "O campo cliente precisa ser preenchido!";
			return response;
		}

		if (request.getData() == null) {

			response.message = "O campo data precisa ser preenchido!";
			return response;
		}

		if (request.getQntDiaria() <= 0) {
			response.message = "O campo Quantidade de Diaria precisa ser preenchido!";
			return response;
		}

		if (request.getSituacao().isEmpty()) {
			response.message = "O campo situação precisa ser preenchido!";
			return response;

		}

		ocupation.setData(request.getData());
		ocupation.setQntDiaria(request.getQntDiaria());
		ocupation.setSituacao(request.getSituacao());

		Quarto quart = new Quarto();
		quart.setId(request.getQuartoId());
		ocupation.setQuarto(quart);

		Cliente client = new Cliente();
		client.setId(request.getClienteId());
		ocupation.setCliente(client);

		_repository.save(ocupation);

		response.statusCode = 201;
		response.message = "Ocupacão incluida com sucesso!";
		return response;
	}

	public OcupacaoListResponse listagem() {

		List<Ocupacao> listagem = _repository.findAll();

		OcupacaoListResponse response = new OcupacaoListResponse();
		response.setOcupacoes(listagem);
		response.statusCode = 200;
		response.message = "Listagem efetuada com sucesso!";
		return response;

	}
}
