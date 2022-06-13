package br.unitins.agendaplus.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Medico;

public class MedicoRepository extends Repository<Medico> {

	public List<Object[]> findByNomeSQL(String nome) throws RepositoryException {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append("  	u ");
			sql.append("FROM ");
			sql.append("  Medico u ");
			sql.append("WHERE ");
			sql.append("  u.nome LIKE :nome ");

			Query query = getEntityManager().createNativeQuery(sql.toString());
			query.setParameter("nome", "%" + nome + "%");

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNomeSQL.");
		}
	}

	public List<Medico> findByNome(String nome, Integer maxResults) throws RepositoryException {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Medico u ");
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

	public List<Medico> findByNome(String nome) throws RepositoryException {
		return findByNome(nome, null);
	}

}
