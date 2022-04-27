package br.unitins.agendaplus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.repository.PacienteRepository;
import br.unitins.agendaplus.model.Paciente;

@Named
@ViewScoped
public class PacienteController extends Controller<Paciente> implements Serializable {

	private static final long serialVersionUID = 4910911238765692801L;
	private List<Paciente> listaPaciente;
	private String nomePesquisa;

	public PacienteController() {
		super(new PacienteRepository());
	}

	public void pesquisar() {
		PacienteRepository repo = new PacienteRepository();
		try {
			listaPaciente = repo.findByNome(getNomePesquisa());
		} catch (RepositoryException e) {
			e.printStackTrace();
			listaPaciente = new ArrayList<Paciente>();
		}
	}

	public void editar(Paciente cliente) {
		setEntity(cliente);
	}

	public List<Paciente> getListaPaciente() {
		if (listaPaciente == null) {
			listaPaciente = new ArrayList<Paciente>();
		}
		return listaPaciente;
	}

	@Override
	public Paciente getEntity() {
		if (entity == null)
			entity = new Paciente();
		return entity;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

}
