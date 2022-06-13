package br.unitins.agendaplus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.controller.listing.PacienteListing;
import br.unitins.agendaplus.model.Paciente;
import br.unitins.agendaplus.repository.PacienteRepository;

@Named
@ViewScoped
public class PacienteController extends Controller<Paciente> implements Serializable {

	private static final long serialVersionUID = -5405951262794133772L;
	
	public PacienteController() {
		super(new PacienteRepository());
	}
	
	@Override
	public Paciente getEntity() {
		if (entity == null)
			entity = new Paciente();
		return entity;
	}
	
	public void abrirPacienteListing() {
		PacienteListing listing = new PacienteListing();
		listing.open();
	}
	
	public void obterPacienteListing(SelectEvent<Paciente> event) {
		setEntity(event.getObject());
	}
	

	
}
