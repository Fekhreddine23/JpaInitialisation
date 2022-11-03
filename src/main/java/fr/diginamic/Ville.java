package fr.diginamic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Ville")
public class Ville {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOM", table = "Ville")
	private String nom;
	
	@Column(name = "CODEPOSTAL", table = "Ville")
	private int codePostal;
	
	@Column(name="dernierRecensement", table = "Ville")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dernierRecensementDate;
	
	@Column(name = "categories", table = "Ville")
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	
	@ManyToOne //reference entre ville qui posssede une seule region
	@JoinColumn(name="Region_id")
	private Region region; 

	
	
	//reference manyToMany
	@ManyToMany
	@JoinTable(name = "lien_ville_habitants",
			joinColumns = @JoinColumn(name="id_ville", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name="id_habitants", referencedColumnName = "id"))
	private List<Habitant> habitants = new ArrayList<Habitant>();
	// constructor vide
	public Ville() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public Date getDernierRecensementDate() {
		return dernierRecensementDate;
	}

	public void setDernierRecensementDate(Date d) {
		this.dernierRecensementDate = d;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + ", dernierRecensementDate="
				+ dernierRecensementDate + ", categorie=" + categorie + "]";
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Habitant> getHabitants() {
		return habitants;
	}

	public void setHabitants(List<Habitant> habitants) {
		this.habitants = habitants;
	}

	



	 

}
