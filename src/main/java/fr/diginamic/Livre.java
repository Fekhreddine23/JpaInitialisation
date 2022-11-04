package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "LIVRE")
public class Livre {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "titre") // titre
	private String titre;

	@Column(name = "auteur") // titre
	private String auteur;

	// reference manyToMany
	@ManyToMany
	@JoinTable(name = "COMPO", joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "id"))

	// liste emprunts
	private List<Emprunt> emprunts = new ArrayList<Emprunt>();

	public Livre() {
		// La table LIVRE a un identifiant, un titre et un auteur
	}

	public int getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "LIVRE [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}

}
