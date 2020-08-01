package com.minha.esolaJasmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minha.esolaJasmin.model.Turma;
import com.minha.esolaJasmin.repository.TurmaRepository;

@RestController
@RequestMapping ("/turma")
@CrossOrigin ("*")
public class TurmaController {
	
	@Autowired
	private TurmaRepository repository;
	
	@GetMapping
	public ResponseEntity <List<Turma>> getAllTurma(){ //LISTAR
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity <Turma> getByIdTurma(@PathVariable long id){ // LISTAR POR ID
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity <Turma> postTurma(@RequestBody Turma turma){ //INCLUIR
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turma));
	}
	
	@PutMapping
	public ResponseEntity <Turma> putTurma(@RequestBody Turma turma){ //ALTERAR
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(turma));
	}
	
	@DeleteMapping ("/{id}")
	public void deleteTurma (@PathVariable long id) { //DELETAR
		repository.deleteById(id);
	}
}
