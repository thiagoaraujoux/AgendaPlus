package br.unitins.agendaplus.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Atendimento  extends DefaultEntity<Atendimento> implements Serializable {

	private static final long serialVersionUID = 4956676278811065858L;

	@Column(length = 100)
	private String descricaoAtendimento;

	@OneToOne
	@JoinColumn(name="id_agendamento", unique=true)
	private Agendamento agendamento; 
	
	
	
	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public String getDescricaoAtendimento() {
		return descricaoAtendimento;
	}

	public void setDescricaoAtendimento(String descricaoAtendimento) {
		this.descricaoAtendimento = descricaoAtendimento;
	}

	
}
