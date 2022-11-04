package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom") // nom
	private String nom;

	@Column(name = "prenom") // nom
	private String prenom;

	// relations client qui a une ou plusieurs emprunts
	@OneToMany(mappedBy = "clients")
	private List<Emprunt> emprunts = new ArrayList<Emprunt>(); // arraylist Emprunt

	public Client() {
		// construct vide
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CLIENT [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
