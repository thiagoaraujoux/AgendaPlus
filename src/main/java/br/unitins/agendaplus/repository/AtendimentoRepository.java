package br.unitins.agendaplus.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.agendaplus.application.RepositoryException;
import br.unitins.agendaplus.model.Atendimento;
import br.unitins.agendaplus.model.Usuario;

public class AtendimentoRepository extends Repository<Atendimento> {

	public List<Atendimento> findByNome(String filtro) throws RepositoryException {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Atendimento u ");
			jpql.append("WHERE ");
			jpql.append("  u.descricaoAtendimento LIKE :descricaoAtendimento ");

			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("descricaoAtendimento", "%" + filtro + "%");

			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByid.");
		}

	}

}