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
@Table (name = "Contas")
public class Conta implements Serializable {

	/**
	 * Autor: felixpessoa
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;

	private double saldo;
	private double limite;
	private String tipoCota;

	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Conta() {
		super();
	}

	public Conta(Integer numero, double saldo, double limite, String tipoCota, Usuario usuario) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.limite = limite;
		this.tipoCota = tipoCota;
		this.usuario = usuario;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public String getTipoCota() {
		return tipoCota;
	}

	public void setTipoCota(String tipoCota) {
		this.tipoCota = tipoCota;
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
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Conta other = (Conta) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "conta [numero=" + numero + ", saldo=" + saldo + ", limite=" + limite + ", tipoCota=" + tipoCota
				+ ", usuario=" + usuario + "]";
	}

}
