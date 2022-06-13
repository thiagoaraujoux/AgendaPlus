package br.unitins.agendaplus.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Paciente extends PessoaFisica {

	@OneToMany(mappedBy="paciente")
	private List<Agendamento> listaAgendamento;
}
