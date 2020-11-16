/*package br.hoteleveris.app.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.model.Quarto;

import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class OcupacaoService {

	@Autowired
	final OcupacaoRepository _repository;

	public OcupacaoService(OcupacaoRepository repository) {
		_repository = repository;

	}

	public BaseResponse incluir(OcupacaoRequest request) {
		Ocupacao ocupacao = new Ocupacao(null, null);
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;
		
		
		if() {
			
			
		}

		Cliente newCliente = new Cliente();
		newCliente.setId(request.getClienteId());

		Quarto newQuarto = new Quarto();
		newQuarto.setId(request.getQuartoId());

		ocupacao.setQntDiaria(request.getQntDiaria());
		ocupacao.setData(request.getData());

		_repository.save(ocupacao);

		response.message = "Comodidade incluida com sucesso!";
		response.statusCode = 201;
		return response;
	}

}*/
