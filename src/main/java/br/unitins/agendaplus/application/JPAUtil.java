package br.unitins.agendaplus.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = null;
	
	private JPAUtil() {
	}
	
	public static EntityManager getEntityManager() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("AgendaPlus");
		return emf.createEntityManager();
	}

}
