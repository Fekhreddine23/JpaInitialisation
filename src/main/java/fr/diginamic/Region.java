package fr.diginamic;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "region")
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="dernierRecensement", table = "region")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dernierRecensementDate;

	@Column(name = "NOM", table = "region")
	private String region;

	// relations region qui a une ou plusieurs villes
	@OneToMany(mappedBy = "region")
	private List<Ville> villes = new ArrayList<Ville>(); // arraylist Ville

	// constructor vide
	public Region() {
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public Date getDernierRecensementDate(Date date) {
		return getDernierRecensementDate(date);
	}

	public void setDernierRecensementDate(Date d) {
		this.dernierRecensementDate = d;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", region=" + region + "]";
	}

	

}
