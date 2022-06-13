package br.unitins.agendaplus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.controller.listing.MedicamentoListing;
import br.unitins.agendaplus.model.Medicamento;
import br.unitins.agendaplus.repository.MedicamentoRepository;

@Named
@ViewScoped
public class MedicamentoController extends Controller<Medicamento> implements Serializable {

	private static final long serialVersionUID = -5405951262794133772L;
	
	public MedicamentoController() {
		super(new MedicamentoRepository());
	}
	
	@Override
	public Medicamento getEntity() {
		if (entity == null)
			entity = new Medicamento();
		return entity;
	}
	
	public void abrirMedicamentoListing() {
		MedicamentoListing listing = new MedicamentoListing();
		listing.open();
	}
	
	public void obterMedicamentoListing(SelectEvent<Medicamento> event) {
		setEntity(event.getObject());
	}
	

	
}
