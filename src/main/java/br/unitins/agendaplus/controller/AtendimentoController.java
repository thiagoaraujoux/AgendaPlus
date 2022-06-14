package br.unitins.agendaplus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.controller.listing.AtendimentoListing;
import br.unitins.agendaplus.controller.listing.AtendenteListing;
import br.unitins.agendaplus.controller.listing.MedicoListing;
import br.unitins.agendaplus.model.Atendimento;
import br.unitins.agendaplus.model.Agendamento;
import br.unitins.agendaplus.model.Atendente;
import br.unitins.agendaplus.model.Atendimento;
import br.unitins.agendaplus.model.Medico;
import br.unitins.agendaplus.model.Paciente;
import br.unitins.agendaplus.repository.AtendimentoRepository;
import br.unitins.agendaplus.repository.AgendamentoRepository;
import br.unitins.agendaplus.repository.AtendenteRepository;
import br.unitins.agendaplus.repository.MedicoRepository;
import br.unitins.agendaplus.repository.PacienteRepository;

@Named
@ViewScoped
public class AtendimentoController extends Controller<Atendimento> implements Serializable {

	private static final long serialVersionUID = -6573745722117503250L;
	
	public AtendimentoController() {
		super(new AtendimentoRepository());
	}

	@Override
	protected void limparRelacionamentosNaoObrigatorios() {
		if (getEntity().getAgendamento().getId() == null)
			getEntity().setAgendamento(null);
		
	}


	public void abrirAtendimentoListing() {
		AtendimentoListing listing = new AtendimentoListing();
		listing.open();
	}

	public void obterAtendimentoListing(SelectEvent<Atendimento> event) {
		setEntity(event.getObject());
	
	}

	public List<Agendamento> completeAgendamento(String filtro) {
		AgendamentoRepository repo = new AgendamentoRepository();
		try {
			return repo.findByDataSQL(filtro);
		} catch (RepositoryException e) {
			e.printStackTrace();
			return new ArrayList<Agendamento>();
		}
	}

	@Override
	public Atendimento getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
