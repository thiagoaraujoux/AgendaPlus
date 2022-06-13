package br.unitins.agendaplus.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PessoaFisica extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9166408909708967491L;

	@Column(length = 60)
	private String cpf;

//	@ManyToOne
//	@JoinColumn(name = "id_estado")
//	private Estado estado;


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

//	public Estado getEstado() {
//		return estado;
//	}

//	public void setEstado(Estado estado) {
//		this.estado = estado;
//	}

}