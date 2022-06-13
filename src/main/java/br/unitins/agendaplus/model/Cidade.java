package br.unitins.agendaplus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Cidade extends DefaultEntity {

	private String nome;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
