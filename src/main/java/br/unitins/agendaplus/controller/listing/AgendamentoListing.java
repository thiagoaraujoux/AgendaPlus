package br.unitins.agendaplus.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.application.Util;
import br.unitins.agendaplus.controller.listing.Listing;
import br.unitins.agendaplus.model.Agendamento;
import br.unitins.agendaplus.repository.AgendamentoRepository;

@Named
@ViewScoped
public class AgendamentoListing extends Listing<Agendamento> {

	private static final long serialVersionUID = -8235200253459121249L;
	private String filtro;

	public AgendamentoListing() {
		super("agendamentolisting", new AgendamentoRepository());
	}

	@Override
	public void pesquisar() {
		AgendamentoRepository repo = new AgendamentoRepository();
		try {
			setList(repo.findByData(filtro));
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage("Problema ao realizar a consulta.");
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
