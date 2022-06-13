package br.unitins.agendaplus.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.application.Util;
import br.unitins.agendaplus.model.Medico;
import br.unitins.agendaplus.repository.MedicoRepository;

@Named
@ViewScoped
public class MedicoListingSQL extends ListingSQL<Medico> {



	private static final long serialVersionUID = -148292917443139490L;
	private String filtro;

	public MedicoListingSQL() {
		super("medicolistingsql", new MedicoRepository());
	}

	@Override
	public void pesquisar() {
		MedicoRepository repo = new MedicoRepository();
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
