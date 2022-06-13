package br.unitins.agendaplus.controller;


import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.application.Session;
import br.unitins.agendaplus.application.Util;
import br.unitins.agendaplus.model.Usuario;
import br.unitins.agendaplus.repository.UsuarioRepository;

@Named
@RequestScoped
public class LoginController {

	private Usuario usuario;
	
	public void entrar() {
		UsuarioRepository repo = new UsuarioRepository();
		Usuario usuarioLogado = null;
		try {
			usuarioLogado = repo.validarLogin(getUsuario());
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		if (usuarioLogado != null) {
			//Adicionar na sessao o objeto usuarioLogado
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			context.getSessionMap().put("usuarioLogado", usuarioLogado);
			Session.getInstance().set("usuarioLogado", usuarioLogado);
			
			// redirecionando para o template
			Util.redirect("/AgendaPlus/faces/inicio.xhtml");
			
		}
		Util.addErrorMessage("Login ou senha inválido.");
		
	}
	
	public void limpar() {
		usuario = null;
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}