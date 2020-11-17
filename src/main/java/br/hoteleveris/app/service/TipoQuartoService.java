package br.hoteleveris.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.TipoQuartoRepository;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.TipoQuartoListResponse;

@Service
public class TipoQuartoService {

	@Autowired
	final TipoQuartoRepository _repository;

	public TipoQuartoService(TipoQuartoRepository repository) {
		_repository = repository;

	}

	public BaseResponse incluir(TipoQuartoRequest request) {
		TipoQuarto tipoquarto = new TipoQuarto();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getValor() == null || request.getValor() <= 0) {
			response.message = "O campo valor precisa ser preenchido e não pode ser zero";
			return response;
		}

		if (request.getDescricao().isEmpty()) {
			response.message = "O campo descricão precisa ser preenchido";
			return response;
		}

		tipoquarto.setValor(request.getValor());
		tipoquarto.setDescricao(request.getDescricao());

		_repository.save(tipoquarto);
		response.message = "O tipo de quarto foi incluido com sucesso!";
		response.statusCode = 201;
		return response;

	}
}
