package br.unitins.agendaplus.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Medico extends PessoaFisica {
	
	@OneToMany(mappedBy="medico")
	private List<Agendamento> listaAgendamento;

}
