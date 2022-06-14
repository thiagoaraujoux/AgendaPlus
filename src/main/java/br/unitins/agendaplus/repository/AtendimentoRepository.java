package br.unitins.agendaplus.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Atendimento;

public class AtendimentoRepository extends Repository<Atendimento> {

	public List<Atendimento> findById(String id, Integer maxResults) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Agendamento u ");
			jpql.append("WHERE ");
			jpql.append("  u.id LIKE :id ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("id", "%" + id + "%");
			
			if (maxResults != null)
				query.setMaxResults(maxResults);
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByData.");
		}
	}
	
	public List<Atendimento> findById(String id) throws RepositoryException {
		return findById(id, null);
	}
	
	

}