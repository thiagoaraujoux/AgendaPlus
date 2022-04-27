package br.unitins.agendaplus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Medico;
import br.unitins.agendaplus.repository.MedicoRepository;

@Named
@ViewScoped
public class MedicoController extends Controller<Medico> implements Serializable {

	private static final long serialVersionUID = -7874660060928175242L;
	private List<Medico> listaMedico;
	private String nomePesquisa;

	public MedicoController() {
		super(new MedicoRepository());
	}

	public void pesquisar() {
		MedicoRepository repo = new MedicoRepository();
		try {
			listaMedico = repo.findByNome(getNomePesquisa());
		} catch (RepositoryException e) {
			e.printStackTrace();
			listaMedico = new ArrayList<Medico>();
		}
	}

	public void editar(Medico medico) {
		setEntity(medico);
	}

	public List<Medico> getListaMedico() {
		if (listaMedico == null) {
			listaMedico = new ArrayList<Medico>();
		}
		return listaMedico;
	}

	@Override
	public Medico getEntity() {
		if (entity == null)
			entity = new Medico();
		return entity;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

}
