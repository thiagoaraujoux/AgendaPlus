package br.unitins.agendaplus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Usuario;
import br.unitins.agendaplus.repository.Repository;
import br.unitins.agendaplus.application.JPAUtil;

public class UsuarioRepository extends Repository<Usuario> {

	public UsuarioRepository() {
		super();
	}

	public Usuario findUsuario(String login, String senha) throws RepositoryException {

		try {
			EntityManager em = JPAUtil.getEntityManager();

			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Usuario u ");
			jpql.append("WHERE ");
			jpql.append("  u.login = :login ");
			jpql.append("  AND u.senha = :senha ");

			Query query = em.createQuery(jpql.toString());
			query.setParameter("login", login);
			query.setParameter("senha", senha);

			// Utilizar o single result quando tem certeza de um unico retorno de objetos
			// O single result gera um excecao quando nao encontra a informacao
			return (Usuario) query.getSingleResult();

		} catch (Exception e) {
			System.out.println("Erro ao realizar uma consulta ao banco.");
			e.printStackTrace();
			return null;
		}

	}

	public List<Usuario> findByNome(String nome) throws RepositoryException {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Usuario u ");
			jpql.append("WHERE ");
			jpql.append("  u.nome LIKE :nome ");

			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");

			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}
	}

	public List<Usuario> findAll() throws RepositoryException {

		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("SELECT u FROM Usuario u ORDER BY u.nome ");

			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao realizar uma consulta ao banco.");
			e.printStackTrace();
			throw new RepositoryException("Erro ao realizar uma consulta ao banco.");
		}

	}

}
