package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.QuartoListResponse;
import br.hoteleveris.app.response.QuartoResponse;
import br.hoteleveris.app.service.QuartoService;

@RestController
@RequestMapping("/quartos")
public class QuartoController extends BaseController {

	@Autowired
	public QuartoService _service;

	@PostMapping()
	public ResponseEntity<BaseResponse> incluir(@RequestBody QuartoRequest request) {
		try {
			BaseResponse response = _service.incluir(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);

		}

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		try {
			QuartoResponse response = _service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
	}

	@GetMapping(path = "/{id}/obterporquarto")
	public ResponseEntity obterporquarto(@PathVariable Long id) {
		try {
			QuartoListResponse response = _service.obterporquarto(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
	}
	
	
	@PatchMapping("/{id}")

    public ResponseEntity<BaseResponse> atualizar(@Validated @PathVariable("id") Long id,
            @RequestBody SituacaoQuartoRequest request) {
        try {

            BaseResponse response = _service.atualizar(id, request);
            return ResponseEntity.status(response.statusCode).body(response);
        } catch (Exception e) {

        	return ResponseEntity.status(error.statusCode).body(error);
        }

    }
	
	
	
}