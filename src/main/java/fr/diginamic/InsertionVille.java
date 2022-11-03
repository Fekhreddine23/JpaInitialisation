package fr.diginamic;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertionVille {

	 

	public static void main(String[] args) {
		// Insérer 2 villes de votre choix en table via JPA.
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recensement");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		//date
		Date d =  Calendar.getInstance().getTime(); 
		//Insérer une nouvelle région en base de données
				Ville m = new Ville();
				
				m.setNom("Montpellier");
				m.setCodePostal(34000);
				m.setDernierRecensementDate(d);
				m.setCategorie(Categorie.MOYENNE);
				em.persist(m);
				 
				
				
				//creation region
				Region r = new Region();
				r.setRegion("Bretagne");
				r.setDernierRecensementDate(new Date());
				em.persist(r);
				
				//creation ville
				Ville t = new Ville();
				t.setNom("Rennes");
				t.setCodePostal(35000);
				t.setDernierRecensementDate(d);
				t.setCategorie(Categorie.GRANDE);
				t.setRegion(r);
				em.persist(t);
				

				//creation relation manyTomany
				Habitant alice = new Habitant();
				alice.setNom("fanfan");
				alice.setPrenom("alice");
				em.persist(alice);
				
				 t.getHabitants().add(alice);
				
				//liste de villes
				
				
				
				
				
				
				//relations region villes
				Ville p = new Ville();
				
				p.setNom("Paris");
				p.setCodePostal(34000);
				p.setDernierRecensementDate(d);
				p.setCategorie(Categorie.GRANDE);
				
				em.persist(p);
				 
				transaction.commit();

	}

}
