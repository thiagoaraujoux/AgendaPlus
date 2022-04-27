package br.unitins.agendaplus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.repository.MedicamentoRepository;
import br.unitins.agendaplus.repository.UsuarioRepository;
import br.unitins.agendaplus.model.Medicamento;
import br.unitins.agendaplus.model.Usuario;

@Named
@ViewScoped
public class MedicamentoController extends Controller<Medicamento> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6890642885248023463L;
	private List<Medicamento> listaMedicamento;
	private String nomePesquisa;

	public MedicamentoController() {
		super(new MedicamentoRepository());
	}

	public void pesquisar() {
		MedicamentoRepository repo = new MedicamentoRepository();
		try {
			listaMedicamento = repo.findByNome(getNomePesquisa());
		} catch (RepositoryException e) {
			e.printStackTrace();
			listaMedicamento = new ArrayList<Medicamento>();
		}
	}

	public void editar(Medicamento medicamento) {
		setEntity(medicamento);
	}

	public List<Medicamento> getListaMedicamento() {
		if (listaMedicamento == null) {
			listaMedicamento = new ArrayList<Medicamento>();
		}
		return listaMedicamento;
	}

	@Override
	public Medicamento getEntity() {
		if (entity == null)
			entity = new Medicamento();
		return entity;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

}
