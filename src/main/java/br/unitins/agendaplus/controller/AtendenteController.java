package br.unitins.agendaplus.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.agendaplus.controller.listing.AtendenteListing;
import br.unitins.agendaplus.model.Atendente;
import br.unitins.agendaplus.model.Atendente;
import br.unitins.agendaplus.repository.AtendenteRepository;

@Named
@ViewScoped
public class AtendenteController extends Controller<Atendente> implements Serializable {

	private static final long serialVersionUID = 2891287027535893953L;

	public AtendenteController() {
		super(new AtendenteRepository());
	}

	@Override
	public Atendente getEntity() {
		if (entity == null)
			entity = new Atendente();
		return entity;
	}

	public void abrirAtendenteListing() {
		AtendenteListing listing = new AtendenteListing();
		listing.open();
	}

	public void obterAtendenteListing(SelectEvent<Atendente> event) {
		setEntity(event.getObject());
	}

}
