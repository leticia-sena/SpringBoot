package com.segproj.segproj.mentalidade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/mentalidades")
public class MentalidadController {
	
	@GetMapping
	public String mentalidades () {
		return "Habilidades e Mentalidades utilizadas nesta atividade:\n|Atenção aos detalhes\n|Persistencia\n|Mentalidade de Crescimento.";
	}

}
