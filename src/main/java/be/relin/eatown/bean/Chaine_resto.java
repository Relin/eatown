package be.relin.eatown.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Chaine_resto")
public class Chaine_resto implements java.io.Serializable{

	private int id;
	
	private String name;
	private String www;
	private String description;
	
	private Set<Resto> restos = new HashSet<Resto>(0);
	private Logo logo;
	private Set<Town> towns = new HashSet<Town>(0);
	
	public Chaine_resto() {}
	
		public Chaine_resto(int id, String name, String www, String description,
			Set<Resto> restos, Logo logo, Set<Town> towns) {
		super();
		this.id = id;
		this.name = name;
		this.www = www;
		this.description = description;
		this.restos = restos;
		this.logo = logo;
		this.towns = towns;
	}


	@Id
	@Column(name = "CHAINE_RESTO_ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	@Column(name = "NAME", nullable = false, length = 25)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "WWW", nullable = true, length = 100)
	public String getWww() {
		return www;
	}
	public void setWww(String www) {
		this.www = www;
	}
	
	@Column(name = "DESCRIPTION", nullable = true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chaine_resto")
	public Set<Resto> getRestos() {
		return restos;
	}
	public void setRestos(Set<Resto> restos) {
		this.restos = restos;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "chaine_resto")
	public Logo getLogo() {
		return logo;
	}
	public void setLogo(Logo logo) {
		this.logo = logo;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "CHAINE_TOWN",
			joinColumns = { @JoinColumn(name = "CHAINE_RESTO_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "TOWN_ID", nullable = false, updatable = false) })
	public Set<Town> getTowns() {
		return towns;
	}
	public void setTowns(Set<Town> towns) {
		this.towns = towns;
	}
	
}
