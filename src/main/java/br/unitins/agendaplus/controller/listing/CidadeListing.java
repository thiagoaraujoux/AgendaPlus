package br.unitins.agendaplus.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.application.Util;
import br.unitins.agendaplus.model.Cidade;
import br.unitins.agendaplus.repository.CidadeRepository;

@Named
@ViewScoped
public class CidadeListing extends Listing<Cidade> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4266296700501563188L;
	private String filtro;

	public CidadeListing() {
		super("cidadelisting", new CidadeRepository());
	}

	@Override
	public void pesquisar() {
		CidadeRepository repo = new CidadeRepository();
		try {
			setList(repo.findByNome(filtro));
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
