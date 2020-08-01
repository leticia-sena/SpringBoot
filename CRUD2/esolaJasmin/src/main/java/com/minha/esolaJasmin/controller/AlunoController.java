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

import com.minha.esolaJasmin.model.Aluno;
import com.minha.esolaJasmin.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

	@Autowired
	private AlunoRepository repository;

	@GetMapping
	public ResponseEntity<List<Aluno>> getAllAluno() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Aluno> getById (@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Aluno> postAluno(@RequestBody Aluno aluno){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
	}
	
	@PutMapping
	public ResponseEntity<Aluno> putAluno(@RequestBody Aluno aluno){
		return ResponseEntity.ok(repository.save(aluno));
	}
	
	@DeleteMapping ("/{id}")
	public void deleteAluno (@PathVariable long id) {
		repository.deleteById(id);
	}

}
