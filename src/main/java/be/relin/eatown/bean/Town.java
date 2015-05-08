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
@Table(name="Town")
public class Town implements java.io.Serializable{

    private int id;
    
    private String name;
    
    private Set<Resto> restos = new HashSet<Resto>(0);
    private Set<Chaine_resto> chaine_restos = new HashSet<Chaine_resto>(0);
    private Country country;
    
    public Town() {}
    
    public Town(int id, String name, Set<Resto> restos,
			Set<Chaine_resto> chaine_restos, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.restos = restos;
		this.chaine_restos = chaine_restos;
		this.country = country;
	}



	@Id
	@Column(name = "TOWN_ID", unique = true, nullable = false)
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
	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "town")
	public Set<Resto> getRestos() {
		return restos;
	}
	public void setRestos(Set<Resto> restos) {
		this.restos = restos;
	}
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "CHAINE_TOWN",
			joinColumns = { @JoinColumn(name = "TOWN_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "CHAINE_RESTO_ID", nullable = false, updatable = false) })
	public Set<Chaine_resto> getChaine_restos() {
		return chaine_restos;
	}
	public void setChaine_restos(Set<Chaine_resto> chaine_restos) {
		this.chaine_restos = chaine_restos;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY", nullable = false)
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
}
