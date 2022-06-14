package br.unitins.agendaplus.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Agendamento;

public class AgendamentoRepository extends Repository<Agendamento> {

	public List<Agendamento> findByDataSQL(String data) throws RepositoryException {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append("  	u ");
			sql.append("FROM ");
			sql.append("  Agendamento u ");
			sql.append("WHERE ");
			sql.append("  u.data LIKE :data ");

			Query query = getEntityManager().createNativeQuery(sql.toString());
			query.setParameter("data", "%" + data + "%");

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByDataSQL.");
		}
	}

	public List<Agendamento> findByData(String data, Integer maxResults) throws RepositoryException {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Agendamento u ");
			jpql.append("WHERE ");
			jpql.append("  u.data LIKE :data ");

			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("data", "%" + data + "%");

			if (maxResults != null)
				query.setMaxResults(maxResults);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByData.");
		}
	}

	public List<Agendamento> findByData(String data) throws RepositoryException {
		return findByData(data, null);
	}

}