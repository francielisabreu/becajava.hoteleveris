package br.hoteleveris.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.hoteleveris.app.model.Ocupacao;

import br.hoteleveris.app.repository.OcupacaoRepository;

import br.hoteleveris.app.request.TransferenciaRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class FaturaService {

	@Autowired
	public OcupacaoRepository ocupacaoRepository;

	private String hotelhash = "hotel";

	public void inserir() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8081/operacoes/transferencia";

		List<Ocupacao> lista = ocupacaoRepository.findBySituacao("N");

		for (Ocupacao ocupacao : lista) {
			double valor = ocupacao.getQuarto().getTipoQuarto().getValor() * ocupacao.getQntDiaria();

			TransferenciaRequest transferencia = new TransferenciaRequest();

			transferencia.setHashDestino(hotelhash);
			transferencia.setHashOrigem(ocupacao.getCliente().getHash());
			transferencia.setValor(valor);

			BaseResponse response = restTemplate.postForObject(uri, transferencia, BaseResponse.class);

			ocupacao.setSituacao("P");
			ocupacaoRepository.save(ocupacao);
		}
	}

}
