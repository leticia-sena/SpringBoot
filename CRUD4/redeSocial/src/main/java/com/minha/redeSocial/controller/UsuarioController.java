package com.minha.redeSocial.controller;

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

import com.minha.redeSocial.model.Usuario;
import com.minha.redeSocial.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuario() { // LISTAR TODOS OS USUARIOS
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable long id) { // LISTAR USUARIO PELO ID
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) { // INSERIR USUARIO
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}

	@PutMapping
	public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuario) { // ALTERAR USUARIO
		return ResponseEntity.ok(repository.save(usuario));
	}

	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable long id) { // DELETAR USUARIO
		repository.deleteById(id);
	}

}
