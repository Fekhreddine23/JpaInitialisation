package fr.diginamic;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class testLivre {

	public static void main(String[] args) {

		// creer entity
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recensement");
		EntityManager em = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		// TP2 Réaliser un find simple permettant d’extraire un livre
		// en fonction de son id.
		Livre livre = em.find(Livre.class, 4);
		if (livre != null) {
			System.out.println(livre);
		}

		// TP3 Réaliser une requête qui permet d’extraire un emprunt en fonction son id.
		Emprunt emprunt2 = em.find(Emprunt.class, 3);
		if (emprunt2 != null) {
			System.out.println(emprunt2);
		}

		// date
		Date d = Calendar.getInstance().getTime();
		
		
        //creer en 1er un client	
		Client client1 = new Client();
		client1.setNom("Doe");
		client1.setPrenom("John");
		em.persist(client1);
		
		//puis associer a un emprunt
		// creation un objet emprunt
		Emprunt emprunt1 = new Emprunt();
		emprunt1.setDateDebut(d);
		emprunt1.setDateFin(d);
		emprunt1.setDelaiMax(15);
		em.persist(emprunt1);
		
		//Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné.
		client1.getEmprunts();
		//.add(emprunt1);
		
		
		transaction.commit();

	}

}
