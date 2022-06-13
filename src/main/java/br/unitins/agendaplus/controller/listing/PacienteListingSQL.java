package br.unitins.agendaplus.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.application.Util;
import br.unitins.agendaplus.model.Paciente;
import br.unitins.agendaplus.repository.PacienteRepository;

@Named
@ViewScoped
public class PacienteListingSQL extends Listing<Paciente> {

	private static final long serialVersionUID = -7981405629475004427L;
	private String filtro;

	public PacienteListingSQL() {
		super("pacientelistingsql", new PacienteRepository());
	}

	@Override
	public void pesquisar() {
		PacienteRepository repo = new PacienteRepository();
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
