package br.com.felix.demo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Enderecos")
public class Endereco implements Serializable{

	/**
	 * Autor Felixpessoa
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEndereco;
	private String logadouro;
	private int numero;
	private String complemento;
	private String pontoReferencia;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	public Endereco() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Endereco(Integer idEndereco, String logadouro, int numero, String complemento, String pontoReferencia,
			Usuario usuario) {
		super();
		this.idEndereco = idEndereco;
		this.logadouro = logadouro;
		this.numero = numero;
		this.complemento = complemento;
		this.pontoReferencia = pontoReferencia;
		this.usuario = usuario;
	}
	public Integer getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getLogadouro() {
		return logadouro;
	}
	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getPontoReferencia() {
		return pontoReferencia;
	}
	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (idEndereco == null) {
			if (other.idEndereco != null)
				return false;
		} else if (!idEndereco.equals(other.idEndereco))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", logadouro=" + logadouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", pontoReferencia=" + pontoReferencia + ", usuario=" + usuario
				+ "]";
	}
	
	

}
