package fr.diginamic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {

	@Id
	private int id;

	@Column(name = "DATE_DEBUT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebut;

	@Column(name = "DELAI")
	private int delaiMax;

	@Column(name = "dATE_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;

	@ManyToOne // reference entre emprunt qui posssede un seul client
	@JoinColumn(name = "ID_CLIENT")//nom de la colomne de jointure
	private Client clients;

	
	// relations livres et emprunts
	@ManyToMany(mappedBy = "livres")
	private List<Livre> livres = new ArrayList<Livre>();

	@Override
	public String toString() {
		return "EMPRUNT [id=" + id + ", dateDebut=" + dateDebut + ", delaiMax=" + delaiMax + ", dateFin=" + dateFin
				+ ", clients=" + clients + "]";
	}

	public Emprunt() {

	}

	

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDelaiMax() {
		return delaiMax;
	}

	public void setDelaiMax(int delaiMax) {
		this.delaiMax = delaiMax;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
