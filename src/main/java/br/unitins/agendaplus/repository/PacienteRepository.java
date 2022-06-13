package br.unitins.agendaplus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Atendente;
import br.unitins.agendaplus.model.Paciente;
import br.unitins.agendaplus.model.Usuario;
import br.unitins.agendaplus.application.JPAUtil;

public class PacienteRepository extends Repository<Paciente> {
	
	public List<Paciente> findByNomeSQL(String nome) throws RepositoryException {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append("  	u ");
			sql.append("FROM ");
			sql.append("  Paciente u ");
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

	public List<Paciente> findByNome(String nome, Integer maxResults) throws RepositoryException {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Paciente u ");
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

}
