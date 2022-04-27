package br.unitins.agendaplus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone extends DefaultEntity implements Serializable{

	private static final long serialVersionUID = -7801673358747779362L;

	@Column(length = 100)
	private String nome;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
