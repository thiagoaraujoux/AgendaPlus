package br.unitins.agendaplus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.controller.listing.AgendamentoListing;
import br.unitins.agendaplus.controller.listing.AtendenteListing;
import br.unitins.agendaplus.controller.listing.MedicoListing;
import br.unitins.agendaplus.model.Agendamento;
import br.unitins.agendaplus.model.Atendente;
import br.unitins.agendaplus.model.Medico;
import br.unitins.agendaplus.model.Paciente;
import br.unitins.agendaplus.repository.AgendamentoRepository;
import br.unitins.agendaplus.repository.AtendenteRepository;
import br.unitins.agendaplus.repository.MedicoRepository;
import br.unitins.agendaplus.repository.PacienteRepository;

@Named
@ViewScoped
public class AgendamentoController extends Controller<Agendamento> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3527156416335834188L;
	public AgendamentoController() {
		super(new AgendamentoRepository());
	}

	@Override
	protected void limparRelacionamentosNaoObrigatorios() {
		if (getEntity().getMedico().getId() == null)
			getEntity().setMedico(null);
		if (getEntity().getAtendente().getId() == null)
			getEntity().setAtendente(null);
		if (getEntity().getPaciente().getId() == null)
			getEntity().setPaciente(null);
	}

	@Override
	public Agendamento getEntity() {
		if (entity == null) {
			entity = new Agendamento();
			entity.setMedico(new Medico());
			entity.setAtendente(new Atendente());
			entity.setPaciente(new Paciente());
		}

		return entity;
	}

	public void abrirAgendamentoListing() {
		AgendamentoListing listing = new AgendamentoListing();
		listing.open();
	}

	public void obterAgendamentoListing(SelectEvent<Agendamento> event) {
		setEntity(event.getObject());
		
	}

	public void abrirMedicoListing() {
		MedicoListing listing = new MedicoListing();
		listing.open();
	}

	public void obterMedicoListing(SelectEvent<Medico> event) {
		getEntity().setMedico(event.getObject());
	}

	public void abrirAtendenteListing() {
		AtendenteListing listing = new AtendenteListing();
		listing.open();
	}

	public void obterAtendenteListing(SelectEvent<Atendente> event) {
		getEntity().setAtendente(event.getObject());
	}

	public List<Medico> completeMedico(String filtro) {
		MedicoRepository repo = new MedicoRepository();
		try {
			return repo.findByNome(filtro, 4);
		} catch (RepositoryException e) {
			e.printStackTrace();
			return new ArrayList<Medico>();
		}
	}

	public List<Atendente> completeAtendente(String filtro) {
		AtendenteRepository repo = new AtendenteRepository();
		try {
			return repo.findByNome(filtro, 4);
		} catch (RepositoryException e) {
			e.printStackTrace();
			return new ArrayList<Atendente>();
		}
	}
	public List<Paciente> completePaciente(String filtro) {
		PacienteRepository repo = new PacienteRepository();
		try {
			return repo.findByNome(filtro, 4);
		} catch (RepositoryException e) {
			e.printStackTrace();
			return new ArrayList<Paciente>();
		}
	}

}
