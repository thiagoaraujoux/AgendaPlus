package br.unitins.agendaplus.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Estado;

public class EstadoRepository extends Repository<Estado> {

	public List<Estado> findByNome(String nome, Integer maxResults) throws RepositoryException {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  e ");
			jpql.append("FROM ");
			jpql.append("  Estado e ");
			jpql.append("WHERE ");
			jpql.append("  e.nome LIKE :nome ");

			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");

			if (maxResults != null)
				query.setMaxResults(maxResults);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}
	}

	public List<Estado> findByNome(String nome) throws RepositoryException {
		return findByNome(nome, null);
	}

}
