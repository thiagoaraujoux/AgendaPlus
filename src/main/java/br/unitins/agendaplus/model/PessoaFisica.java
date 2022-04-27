package br.unitins.agendaplus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9166408909708967491L;

	@Column(length = 60)
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
