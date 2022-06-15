package br.unitins.agendaplus.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import br.unitins.agendaplus.controller.listing.AtendimentoListing;
import br.unitins.agendaplus.model.Atendimento;
import br.unitins.agendaplus.repository.AtendimentoRepository;

@Named
@ViewScoped
public class AtendimentoController extends Controller<Atendimento> implements Serializable {

	private static final long serialVersionUID = -6573745722117503250L;
	
	public AtendimentoController() {
		super(new AtendimentoRepository());
	}
	
	@Override
	public Atendimento getEntity() {
		if (entity == null)
			entity = new Atendimento();
		return entity;
	}
	
	public void abrirAtendimentoListing() {
		AtendimentoListing listing = new AtendimentoListing();
		listing.open();
	}
	
	public void obterAtendimentoListing(SelectEvent<Atendimento> event) {
		setEntity(event.getObject());
	}
	

	
}