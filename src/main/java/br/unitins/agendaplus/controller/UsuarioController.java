package br.unitins.agendaplus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.repository.UsuarioRepository;
import br.unitins.agendaplus.model.Usuario;
@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4465058873668801157L;
	private List<Usuario> listaUsuario;
	private String nomePesquisa;
	
	public UsuarioController() {
		super(new UsuarioRepository());
	}
	
	public void pesquisar() {
		UsuarioRepository repo = new UsuarioRepository();
		try {
			listaUsuario = repo.findByNome(getNomePesquisa());
		} catch (RepositoryException e) {
			e.printStackTrace();
			listaUsuario = new ArrayList<Usuario>();
		}
	}
	
	public void editar(Usuario usuario) {
		setEntity(usuario);
	}
	
	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			listaUsuario = new ArrayList<Usuario>();
		}
		return listaUsuario;
	}

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}
	
	
	
}
