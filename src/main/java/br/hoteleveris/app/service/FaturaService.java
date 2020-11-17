package br.hoteleveris.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.hoteleveris.app.model.Ocupacao;

import br.hoteleveris.app.repository.OcupacaoRepository;

import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.request.*;

@Service
public class FaturaService{

	@Autowired
	public OcupacaoRepository ocupacaoRepository;

	private String hashContaHotel = "123456";

	public void inserir() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8081/operacao/transferencia";

		List<Ocupacao> lista = ocupacaoRepository.findBySituacao("N");

		for (Ocupacao ocupacao : lista) {
			double valor = ocupacao.getQuarto().getTipoQuarto().getValor() * ocupacao.getQntDiaria();

			TransferenciaRequest transferencia = new TransferenciaRequest();
			

			transferencia.setHashDestino(hashContaHotel);
			transferencia.setHashOrigem(ocupacao.getCliente().getHash());
			transferencia.setValor(valor);

			BaseResponse response = restTemplate.postForObject(uri, transferencia, BaseResponse.class);

			ocupacao.setSituacao("P");
			ocupacaoRepository.save(ocupacao);
		}
	}

	public BaseResponse transferencia() {
		// TODO Auto-generated method stub
		return null;
	}
}