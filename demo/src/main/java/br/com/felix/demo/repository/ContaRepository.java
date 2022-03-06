package br.com.felix.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felix.demo.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{

}
