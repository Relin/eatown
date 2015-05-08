package be.relin.eatown.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Country",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "NAME")})
public class Country implements java.io.Serializable{

	private int id;
	private String Name;
	
	private Set<Town> towns = new HashSet<Town>(0);
	
	public Country() {}
	
	public Country(int id, String name, Set<Town> towns) {
		super();
		this.id = id;
		Name = name;
		this.towns = towns;
	}


	
	@Id
	@Column(name = "COUNTRY_ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "NAME", nullable = false, length = 25)
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Town> getTowns() {
		return towns;
	}
	public void setTowns(Set<Town> towns) {
		this.towns = towns;
	}
	
}
