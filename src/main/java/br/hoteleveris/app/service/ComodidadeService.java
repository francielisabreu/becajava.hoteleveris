package br.hoteleveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.repository.ComodidadeRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ComodidadeResponse;

@Service
public class ComodidadeService {

	@Autowired
	final ComodidadeRepository _repository;

	public ComodidadeService(ComodidadeRepository repository) {
		_repository = repository;

	}

	public BaseResponse incluir(ComodidadeRequest request) {
		Comodidade comodidade = new Comodidade();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getNome().isEmpty()) {
			response.message = "O campo nome precisa ser preenchido";
			return response;
		}

		comodidade.setNome(request.getNome());

		_repository.save(comodidade);

		response.message = "Comodidade incluida com sucesso!";
		response.statusCode = 201;
		return response;
	}

	public ComodidadeResponse Obter(Long id) {
		Optional<Comodidade> cliente = _repository.findById(id);
		ComodidadeResponse response = new ComodidadeResponse();

		if (cliente.isEmpty()) {

			response.message = "Não foi possivel encontrar a comodidade, inserida um valor válido";
			response.statusCode = 400;

			return response;
		}

		response.setNome(cliente.get().getNome());
		response.setId(cliente.get().getId());
	
		response.message = "Cliente obtido com sucesso!";
		response.statusCode = 200;
		return response;

	}

}
