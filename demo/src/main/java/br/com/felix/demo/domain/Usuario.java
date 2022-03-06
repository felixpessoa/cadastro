package br.com.felix.demo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Usuarios")
public class Usuario implements Serializable{

	/**
	 * Autor: felixpessoa
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String dNascimento;
	private String cpf;
	private String telefone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEndereco", referencedColumnName = "idEndereco")
	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "numeroConta", referencedColumnName = "numeroConta")
	private Conta conta;
	
	private LocalDateTime dC;

	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nome, String dNascimento, String cpf, String telefone, Endereco endereco,
			Conta conta, LocalDateTime dC) {
		super();
		this.id = id;
		this.nome = nome;
		this.dNascimento = dNascimento;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.conta = conta;
		this.dC = dC;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getdNascimento() {
		return dNascimento;
	}

	public void setdNascimento(String dNascimento) {
		this.dNascimento = dNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public LocalDateTime getdC() {
		return dC;
	}

	public void setdC(LocalDateTime dC) {
		this.dC = dC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", dNascimento=" + dNascimento + ", cpf=" + cpf + ", telefone="
				+ telefone + ", endereco=" + endereco + ", conta=" + conta + ", dC=" + dC + "]";
	}
	
	
	
	
	

}
