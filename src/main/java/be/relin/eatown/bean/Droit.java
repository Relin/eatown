package be.relin.eatown.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Droit",
		uniqueConstraints = {@UniqueConstraint(columnNames = "NAME") })
public class Droit implements java.io.Serializable{

    private int id;
	
	private String name;
	private String description;
	
	private Set<Groupe> groups = new HashSet<Groupe>(0);
	
	public Droit() {}
	
	public Droit(int id, String name, String description, Set<Groupe> groups) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.groups = groups;
	}


	@Id
	@Column(name = "DROIT_ID", unique = true, nullable = false)
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
	
	@Column(name = "DESCRIPTION", nullable = true, length = 25)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "GROUP_DROIT",
			joinColumns = { @JoinColumn(name = "DROIT_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) })
	public Set<Groupe> getGroups() {
		return groups;
	}

	public void setGroups(Set<Groupe> groups) {
		this.groups = groups;
	}
	
	
	
}