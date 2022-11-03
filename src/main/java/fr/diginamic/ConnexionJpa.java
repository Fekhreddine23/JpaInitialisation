package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConnexionJpa {

	public static void main (String [] args) {
		//Créer une instance d’entityManagerFactory
		//Créer une instance d’entityManager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recensement");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		transaction.commit();
		
		
		//Extraire une région de votre choix à partir de son identifiant.
		Region r = em.find(Region.class, 1);
		System.out.println(r);
		
		
		//Insérer une nouvelle région en base de données
		Region h = new Region();
		h.setId(3);
		h.setRegion("Ile-de-France");
		em.persist(h);
		transaction.begin();
		transaction.commit();
	}

}
