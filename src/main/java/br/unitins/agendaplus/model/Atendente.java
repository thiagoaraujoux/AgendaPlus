package br.unitins.agendaplus.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Atendente extends PessoaFisica {

	@OneToMany(mappedBy="atendente")
	private List<Agendamento> listaAgendamento;
}
