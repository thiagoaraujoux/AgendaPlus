package br.unitins.agendaplus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Medicamento extends DefaultEntity<Medicamento> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8580666800243816712L;

	@Column(length = 60)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
