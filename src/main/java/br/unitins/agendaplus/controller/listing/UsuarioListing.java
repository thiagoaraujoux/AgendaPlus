package br.unitins.agendaplus.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.application.Util;
import br.unitins.agendaplus.model.Usuario;
import br.unitins.agendaplus.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioListing extends Listing<Usuario> {

	private static final long serialVersionUID = -2800428910149904765L;

	private String filtro;

	public UsuarioListing() {
		super("usuariolisting", new UsuarioRepository());
	}

	@Override
	public void pesquisar() {
		UsuarioRepository repo = new UsuarioRepository();
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
