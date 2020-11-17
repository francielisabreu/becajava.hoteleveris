package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.QuartoComodidade;
import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.QuartoComodidadeRepository;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.QuartoListResponse;
import br.hoteleveris.app.response.QuartoResponse;

@Service
public class QuartoService {

	@Autowired
	private QuartoRepository _repository;

	@Autowired
	private QuartoComodidadeRepository repository;

	public BaseResponse incluir(QuartoRequest request) {
		BaseResponse response = new BaseResponse();
		Quarto quarto = new Quarto();

		if (request.getAndar() <= 0) {
			response.message = "O campo andar precisa ser preenchido!";
			response.statusCode = 400;
			return response;
		}

		if (request.getSituacao().isEmpty()) {
			response.message = "O campo situacão precisa ser preenchido!";
			response.statusCode = 400;
			return response;

		}

		if (request.getNumero() <= 0) {
			response.message = "O campo número precisa ser preenchido!";
			response.statusCode = 400;
			return response;

		}

		TipoQuarto newquarto = new TipoQuarto();
		newquarto.setId(request.getTipoQuartoId());
		quarto.setTipoQuarto(newquarto);

		quarto.setAndar(request.getAndar());
		quarto.setSituacao(request.getSituacao());
		quarto.setNumero(request.getNumero());
		quarto.setTipoQuarto(newquarto);

		_repository.save(quarto);

		Optional<Quarto> getquarto = _repository.findByNumero(request.getNumero());

		Long quartoId = getquarto.get().getId();

		for (ComodidadeRequest item : request.getComodidade()) {

			Quarto quart = new Quarto();
			quart.setId(quartoId);

			Comodidade como = new Comodidade();
			como.setId(item.getId());

			QuartoComodidade quartoComodidade = new QuartoComodidade();

			quartoComodidade.setComodidade(como);
			quartoComodidade.setQuarto(quart);

			repository.save(quartoComodidade);

		}

		response.message = "Quarto incluido com sucesso!";
		response.statusCode = 201;
		return response;

	}

	public QuartoResponse obter(Long id) {

		Optional<Quarto> listagem = _repository.findById(id);

		QuartoResponse response = new QuartoResponse();

		response.setId(listagem.get().getId());
		response.setAndar(listagem.get().getAndar());
		response.setNumero(listagem.get().getNumero());
		response.setSituacao(listagem.get().getSituacao());
		response.setTipoQuartoId(listagem.get().getId());

		response.statusCode = 200;
		response.message = "Quarto obtidos com sucesso";

		return response;

	}

	public QuartoListResponse obterporquarto(Long id) {

		List<Quarto> obterTipoQuartoId = _repository.findByTipoQuartos(id);

		QuartoListResponse response = new QuartoListResponse();

		response.setQuartos(obterTipoQuartoId);

		response.statusCode = 200;
		response.message = "Quarto obtido por tipo quarto com sucesso!";

		return response;

	}

	public BaseResponse atualizar(Long id, SituacaoQuartoRequest request) {

		Optional<Quarto> listagem = _repository.findById(id);
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getSituacao().isEmpty()) {
			response.message = "O campo precisa ser preenchido!";
			return response;
		}

		listagem.get().setSituacao(request.getSituacao());
		_repository.save(listagem.get());

		response.statusCode = 200;
		response.message = "Quarto atualizado com sucesso!";
		return response;
	}

}
