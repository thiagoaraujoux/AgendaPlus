package br.unitins.agendaplus.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.controller.listing.CidadeListing;
import br.unitins.agendaplus.controller.listing.EstadoListing;
import br.unitins.agendaplus.model.Cidade;
import br.unitins.agendaplus.model.Estado;
import br.unitins.agendaplus.repository.CidadeRepository;
import br.unitins.agendaplus.repository.EstadoRepository;

@Named
@ViewScoped
public class CidadeController extends Controller<Cidade> implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4971588600773751054L;

	public CidadeController() {
		super(new CidadeRepository());
	}
	
	@Override
	public Cidade getEntity() {
		if (entity == null) {
			entity = new Cidade();
			entity.setEstado(new Estado());
		}
		return entity;
	}
	
	public void abrirCidadeListing() {
		CidadeListing listing = new CidadeListing();
		listing.open();
	}
	
	public void obterCidadeListing(SelectEvent<Cidade> event) {
		setEntity(event.getObject());
	}
	
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent<Estado> event) {
		getEntity().setEstado(event.getObject());
	}
	

	public List<Estado> completeEstado(String filtro) {
		EstadoRepository repo = new EstadoRepository();
		try {
			return repo.findByNome(filtro, 4);
		} catch (RepositoryException e) {
			e.printStackTrace();
			return new ArrayList<Estado>();
		}
	}
}