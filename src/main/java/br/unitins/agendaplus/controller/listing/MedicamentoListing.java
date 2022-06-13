package br.unitins.agendaplus.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.application.Util;
import br.unitins.agendaplus.model.Medicamento;
import br.unitins.agendaplus.repository.MedicamentoRepository;

@Named
@ViewScoped
public class MedicamentoListing extends Listing<Medicamento> {

	private static final long serialVersionUID = -2800428910149904765L;

	private String filtro;

	public MedicamentoListing() {
		super("medicamentolisting", new MedicamentoRepository());
	}

	@Override
	public void pesquisar() {
		MedicamentoRepository repo = new MedicamentoRepository();
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
