package br.hoteleveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.repository.TipoQuartoRepository;

@Service
public class FaturaSerivce {
	
	
	@Autowired
	private QuartoRepository quartoRepository;	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OcupacaoRepository ocupacaoRepository;
	
	@Autowired
	private TipoQuartoRepository tipoQuartoRepository;
	
	
	
	
	

}
