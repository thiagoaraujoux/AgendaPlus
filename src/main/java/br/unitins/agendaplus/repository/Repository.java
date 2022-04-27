package br.unitins.agendaplus.repository;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.unitins.agendaplus.application.JPAUtil;
import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.DefaultEntity;
public class Repository<T extends DefaultEntity> {

	private EntityManager entityManager;

	public Repository() {
		super();
		setEntityManager(JPAUtil.getEntityManager());
	}

	public void save(T entity) throws RepositoryException {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(entity);
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Problema ao executar o save.");
			e.printStackTrace();
			try {
				getEntityManager().getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw new RepositoryException("Problema ao salvar.");
		}

	}

	public void save(T... entitys) throws RepositoryException {
		try {
			getEntityManager().getTransaction().begin();
			for (T entity : entitys) {
				getEntityManager().merge(entity);
			}
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Problema ao executar o save.");
			e.printStackTrace();
			try {
				getEntityManager().getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw new RepositoryException("Problema ao salvar.");
		}
	}

	public void remove(T entity) throws RepositoryException {
		try {
			getEntityManager().getTransaction().begin();
			T obj = getEntityManager().merge(entity);
			getEntityManager().remove(obj);
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Problema ao executar o remove.");
			e.printStackTrace();
			try {
				getEntityManager().getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw new RepositoryException("Problema ao remover.");
		}
	}

	public T findById(int id) throws RepositoryException {
		try {
			// obtendo o tipo da classe de forma generica (a classe deve ser publica)
			final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
			Class<T> tClass = (Class<T>) (type).getActualTypeArguments()[0];
			
			T t = (T) getEntityManager().find(tClass, id);
			
			return t;
		} catch (Exception e) {
			System.out.println("Erro ao executar o método de find.");
			e.printStackTrace();
			throw new RepositoryException("Erro ao buscar os dados");
		}
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	private void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}