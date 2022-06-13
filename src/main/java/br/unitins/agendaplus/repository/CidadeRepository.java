package br.unitins.agendaplus.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Cidade;

public class CidadeRepository extends Repository<Cidade> {

	public List<Cidade> findByNome(String nome) throws RepositoryException {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  e ");
			jpql.append("FROM ");
			jpql.append("  Cidade e ");
			jpql.append("WHERE ");
			jpql.append("  e.nome LIKE :nome ");

			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}
	}

	public List<Object[]> findByNomeSQL(String nome) throws RepositoryException {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append("  	c.id, ");
			sql.append("	c.nome, ");
			sql.append("	e.nome as nomeEstado, ");
			sql.append("	e.sigla ");
			sql.append("FROM ");
			sql.append("  Cidade c, ");
			sql.append("  Estado e ");
			sql.append("WHERE ");
			sql.append("  c.estado_id = e.id ");
			sql.append("  AND c.nome LIKE :nome ");

			Query query = getEntityManager().createNativeQuery(sql.toString());
			query.setParameter("nome", "%" + nome + "%");

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNomeSQL.");
		}
	}

}
