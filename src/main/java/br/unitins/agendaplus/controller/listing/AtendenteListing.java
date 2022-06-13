package br.unitins.agendaplus.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.application.Util;
import br.unitins.agendaplus.model.Atendente;
import br.unitins.agendaplus.repository.AtendenteRepository;

@Named
@ViewScoped
public class AtendenteListing extends Listing<Atendente> {


	private static final long serialVersionUID = 1754534625354743441L;
	
	private String filtro;

	public AtendenteListing() {
		super("atendentelisting", new AtendenteRepository());
	}

	@Override
	public void pesquisar() {
		AtendenteRepository repo = new AtendenteRepository();
		try {
			setList(repo.findByNome(filtro, null));
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
