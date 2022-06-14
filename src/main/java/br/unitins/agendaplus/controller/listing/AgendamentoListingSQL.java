package br.unitins.agendaplus.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.application.Util;
import br.unitins.agendaplus.model.Agendamento;
import br.unitins.agendaplus.repository.AgendamentoRepository;
import br.unitins.agendaplus.repository.AgendamentoRepository;

@Named
@ViewScoped
public class AgendamentoListingSQL extends Listing<Agendamento> {

	private static final long serialVersionUID = -8235200253459121249L;
	private String filtro;

	public AgendamentoListingSQL() {
		super("agendamentolistingsql", new AgendamentoRepository());
	}

	@Override
	public void pesquisar() {
		AgendamentoRepository repo = new AgendamentoRepository();
		try {
			setList(repo.findByDataSQL(filtro));
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
