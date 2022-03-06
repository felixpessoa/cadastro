package br.com.felix.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felix.demo.domain.Usuario;

@Repository
public interface UsuarioRepositoy extends JpaRepository<Usuario, Integer>{

}
