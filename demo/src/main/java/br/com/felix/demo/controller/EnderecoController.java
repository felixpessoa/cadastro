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

import br.com.felix.demo.domain.Endereco;
import br.com.felix.demo.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	private EnderecoRepository repository;
	
	EnderecoController(EnderecoRepository enderecoRepository){
		this.repository = enderecoRepository;
	}
	
	//Mostrar todos
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	//Pesquisar pelo ID
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable (value = "id") Integer idEndereco) {
		return repository.findById(idEndereco).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	//Salvar
	@PostMapping
	public Endereco endereco(@RequestBody Endereco endereco) {
		return repository.save(endereco);
	}
	
	
	//Atualizar
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable ("id") Integer idEndereco, @RequestBody Endereco endereco) {
		return repository.findById(idEndereco).map(record -> {
			record.setLogadouro(endereco.getLogadouro());
			record.setNumero(endereco.getNumero());
			record.setComplemento(endereco.getComplemento());
			record.setPontoReferencia(endereco.getPontoReferencia());
			Endereco updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	
	//Deletar
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer idEndereco){
		return repository.findById(idEndereco).map(record -> {
			repository.deleteById(idEndereco);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
}















