package br.hoteleveris.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faturas")
public class FaturaController extends BaseController {
	
	@Autowired 
	private FaturaService _service;
	
	@PostMapping()
	public ResponseEntity incluir () {
		
		
	}

}
