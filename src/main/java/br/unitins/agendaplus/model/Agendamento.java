package br.unitins.agendaplus.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.exolab.castor.types.DateTime;

@Entity
public class Agendamento extends DefaultEntity<Agendamento> implements Serializable {

	private static final long serialVersionUID = -820558590310360029L;

	@Column(length = 30)
	private String data;

	@Column(length = 100)
	private String motivoConsulta;

	@Column(length = 100)
	private String justificativaCancelamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_medico")
	private Medico medico; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_paciente")
	private Paciente paciente; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_atendente")
	private Atendente atendente; 

	@OneToOne(mappedBy="agendamento")
	private Atendimento atendimento;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public String getJustificativaCancelamento() {
		return justificativaCancelamento;
	}

	public void setJustificativaCancelamento(String justificativaCancelamento) {
		this.justificativaCancelamento = justificativaCancelamento;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	
	
}
