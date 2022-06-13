package br.unitins.agendaplus.controller;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.application.Util;
import br.unitins.agendaplus.model.DefaultEntity;
import br.unitins.agendaplus.repository.Repository;
import br.unitins.agendaplus.repository.UsuarioRepository;
import br.unitins.agendaplus.application.VersionException;

public abstract class Controller<T extends DefaultEntity> {

	private Repository<T> repository;
	protected T entity;

	public Controller(Repository<T> repository) {
		super();
		this.repository = repository;
	}

	public void incluir() {
		try {
			limparRelacionamentosNaoObrigatorios();
			setEntity(getRepository().save(getEntity()));
			Util.addInfoMessage("Inclusao realizada com sucesso.");
			limpar();
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		} catch (VersionException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
	}

	public void salvarSemLimpar() {
		try {
			limparRelacionamentosNaoObrigatorios();
			setEntity(getRepository().save(getEntity()));
			Util.addInfoMessage("Salvo com sucesso.");
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		} catch (VersionException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
	}

	protected void limparRelacionamentosNaoObrigatorios() {

	}

	public void alterar() {
		try {
			limparRelacionamentosNaoObrigatorios();
			setEntity(getRepository().save(getEntity()));
			Util.addInfoMessage("Alteracao realizada com sucesso.");
			limpar();
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		} catch (VersionException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
	}

	public void excluir() {
		try {
			getRepository().remove(getEntity());
			Util.addInfoMessage("Exclusao realizada com sucesso.");
			limpar();
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
	}

	public void limpar() {
		entity = null;
	}

	public Repository<T> getRepository() {
		return repository;
	}

	public abstract T getEntity();

	public void setEntity(T entity) {
		this.entity = entity;
	}

}