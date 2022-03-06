package br.com.felix.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.felix.demo.domain.Conta;
import br.com.felix.demo.repository.ContaRepository;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	private ContaRepository repository;

	ContaController(ContaRepository contaRepository) {
		this.repository = contaRepository;
	}
	
	//Mostrar Todos
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	//Pesquisar Pelo ID
	public ResponseEntity findById(@PathVariable (value = "id") Integer numero) {
		return repository.findById(numero).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Salvar
	@PostMapping
	public Conta conta(@RequestBody Conta conta) {
		return repository.save(conta);
	}
	
	//Atualizar
	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable ("id") Integer numero, @RequestBody Conta conta) {
		return repository.findById(numero).map(record -> {
			record.setSaldo(conta.getSaldo());
			record.setLimite(conta.getLimite());
			Conta updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	//Deletar
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer numero){
		return repository.findById(numero).map(record -> {
			repository.deleteById(numero);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
