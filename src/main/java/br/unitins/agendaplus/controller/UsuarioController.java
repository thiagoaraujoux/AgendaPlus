package br.unitins.agendaplus.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.controller.listing.UsuarioListing;
import br.unitins.agendaplus.model.Usuario;
import br.unitins.agendaplus.repository.UsuarioRepository;
import br.unitins.agendaplus.application.Util;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = -5405951262794133772L;

	private InputStream fotoInputStream = null;

	public UsuarioController() {
		super(new UsuarioRepository());
	}

	public void upload(FileUploadEvent event) {
		UploadedFile uploadFile = event.getFile();
		System.out.println("nome arquivo: " + uploadFile.getFileName());
		System.out.println("tipo: " + uploadFile.getContentType());
		System.out.println("tamanho: " + uploadFile.getSize());

		if (uploadFile.getContentType().equals("image/png")) {
			try {
				fotoInputStream = uploadFile.getInputStream();
				System.out.println("inputStream: " + uploadFile.getInputStream().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Util.addInfoMessage("Upload realizado com sucesso.");
		} else {
			Util.addErrorMessage("O tipo da image deve ser png.");
		}

	}

	@Override
	public void incluir() {
		super.salvarSemLimpar();

		// caso exista uma imagem
		if (getFotoInputStream() != null) {
			// salvando a imagem
			if (!Util.saveImageUsuario(getFotoInputStream(), "png", getEntity().getId())) {
				Util.addErrorMessage("Erro ao salvar. Não foi possível salvar a imagem do usuário.");
				return;
			}
		}
		limpar();
	}

	@Override
	public void alterar() {
		super.salvarSemLimpar();

		// caso exista uma imagem
		if (getFotoInputStream() != null) {
			// salvando a imagem
			if (!Util.saveImageUsuario(getFotoInputStream(), "png", getEntity().getId())) {
				Util.addErrorMessage("Erro ao salvar. Não foi possível salvar a imagem do usuário.");
				return;
			}
		}
		limpar();
	}

	public InputStream getFotoInputStream() {
		return fotoInputStream;
	}

	public void setFotoInputStream(InputStream fotoInputStream) {
		this.fotoInputStream = fotoInputStream;
	}

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}

	public void abrirUsuarioListing() {
		UsuarioListing listing = new UsuarioListing();
		listing.open();
	}

	public void obterUsuarioListing(SelectEvent<Usuario> event) {
		setEntity(event.getObject());
		UsuarioRepository repo = new UsuarioRepository();
		Usuario usuario = null;
		try {
			usuario = repo.findByIdUsuario(getEntity().getId());
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		if (usuario != null) 
			setEntity(usuario);
		else
			getEntity().setId(null);	
	}

}
