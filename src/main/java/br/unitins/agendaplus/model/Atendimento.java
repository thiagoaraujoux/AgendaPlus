package br.unitins.agendaplus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Atendimento  extends DefaultEntity<Atendimento> implements Serializable {

	private static final long serialVersionUID = 4956676278811065858L;

	@Column(length = 100)
	private String descricaoAtendimento;

	@OneToOne
	@JoinColumn(name="id_agendamento")
	private Agendamento agendamento;

	public String getDescricaoAtendimento() {
		return descricaoAtendimento;
	}

	public void setDescricaoAtendimento(String descricaoAtendimento) {
		this.descricaoAtendimento = descricaoAtendimento;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	} 
	
	
	
}
