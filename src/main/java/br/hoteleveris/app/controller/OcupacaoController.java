package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.OcupacaoListResponse;
import br.hoteleveris.app.service.OcupacaoService;

@RestController
@RequestMapping("/ocupacoes")
public class OcupacaoController extends BaseController {

	@Autowired
	public OcupacaoService _service;

	@PostMapping()
	public ResponseEntity<BaseResponse> incluir(@RequestBody OcupacaoRequest request) {

		try {
			BaseResponse response = _service.incluir(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> listagem(@PathVariable Long id) {
		try {
			OcupacaoListResponse clientes = _service.listagem();
			return ResponseEntity.status(clientes.statusCode).body(clientes);
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
	}

}
