package br.unitins.agendaplus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.controller.listing.MedicoListing;
import br.unitins.agendaplus.model.Medico;
import br.unitins.agendaplus.repository.MedicoRepository;

@Named
@ViewScoped
public class MedicoController extends Controller<Medico> implements Serializable {

	private static final long serialVersionUID = -5405951262794133772L;
	
	public MedicoController() {
		super(new MedicoRepository());
	}
	
	@Override
	public Medico getEntity() {
		if (entity == null)
			entity = new Medico();
		return entity;
	}
	
	public void abrirMedicoListing() {
		MedicoListing listing = new MedicoListing();
		listing.open();
	}
	
	public void obterMedicoListing(SelectEvent<Medico> event) {
		setEntity(event.getObject());
	}
	

	
}
