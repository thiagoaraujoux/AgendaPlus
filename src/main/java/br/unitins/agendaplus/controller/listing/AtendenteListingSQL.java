package br.unitins.agendaplus.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.application.Util;
import br.unitins.agendaplus.model.Atendente;
import br.unitins.agendaplus.repository.AtendenteRepository;

@Named
@ViewScoped
public class AtendenteListingSQL extends ListingSQL<Atendente> {


	private static final long serialVersionUID = 1754534625354743441L;
	
	private String filtro;

	public AtendenteListingSQL() {
		super("atendentelistingsql", new AtendenteRepository());
	}

	@Override
	public void pesquisar() {
		AtendenteRepository repo = new AtendenteRepository();
		try {
			setList(repo.findByNomeSQL(filtro));
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
