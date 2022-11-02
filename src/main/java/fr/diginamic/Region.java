package fr.diginamic;

import java.security.PublicKey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "region")
public class Region {

	@Id
	private Integer id;

	@Column(name = "NOM", table = "region")
	private String region;

	public Region() {
	}
	// TODO Auto-generated constructor stub

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

	@Override
	public String toString() {
		return "Region [id=" + id + ", region=" + region + "]";
	}

	

}
