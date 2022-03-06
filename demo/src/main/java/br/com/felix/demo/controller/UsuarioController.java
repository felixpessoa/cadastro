package br.com.felix.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.felix.demo.domain.Usuario;
import br.com.felix.demo.repository.UsuarioRepositoy;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private UsuarioRepositoy repository;
	
	UsuarioController(UsuarioRepositoy usuarioRepository){
		this.repository = usuarioRepository;
	}
	
	//Mostrar Todos
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	//Pesquisar pelo ID
	public ResponseEntity findById(@PathVariable (value = "id") Integer id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//salvar
	@PostMapping
	public Usuario usuario(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	//Atualizar
	@PutMapping(value = "/{id}")
	public ResponseEntity update (@PathVariable ("id") Integer id, @RequestBody Usuario usuario) {
		return repository.findById(id).map(record -> {
			record.setNome(usuario.getNome());
			record.setdNascimento(usuario.getdNascimento());
			record.setTelefone(usuario.getTelefone());
			Usuario updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	
	
	
	
	
	
}
