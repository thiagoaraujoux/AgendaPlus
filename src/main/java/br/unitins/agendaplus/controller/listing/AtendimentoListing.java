package br.unitins.agendaplus.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.application.Util;
import br.unitins.agendaplus.model.Atendimento;
import br.unitins.agendaplus.repository.AtendimentoRepository;

@Named
@ViewScoped
public class AtendimentoListing extends Listing<Atendimento> {

	private static final long serialVersionUID = 3655781217619712958L;
	private String filtro;

	public AtendimentoListing() {
		super("atendimentolisting", new AtendimentoRepository());
	}

	@Override
	public void pesquisar() {
		AtendimentoRepository repo = new AtendimentoRepository();
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
