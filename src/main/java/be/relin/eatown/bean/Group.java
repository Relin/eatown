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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Group",
		uniqueConstraints = {@UniqueConstraint(columnNames = "NAME") })
public class Group implements java.io.Serializable{

    private int id;
    
	private String name;
	
	private Set<Utilisateurs> utilisateurs = new HashSet<Utilisateurs>(0);
	private Avatar avatar;
	private Set<Droit> droits = new HashSet<Droit>(0);
	
	public Group() {}
	
	public Group(int id, String name, Set<Utilisateurs> utilisateurs,
			Avatar avatar, Set<Droit> droits) {
		super();
		this.id = id;
		this.name = name;
		this.utilisateurs = utilisateurs;
		this.avatar = avatar;
		this.droits = droits;
	}


	@Id
	@Column(name = "GROUP_ID", unique = true, nullable = false)
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

	
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_GROUP",
			joinColumns = { @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) })
	public Set<Utilisateurs> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateurs> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVATAR_ID", nullable = false)
	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "GROUP_DROIT",
			joinColumns = { @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "DROIT_ID", nullable = false, updatable = false) })
	public Set<Droit> getDroits() {
		return droits;
	}

	public void setDroits(Set<Droit> droits) {
		this.droits = droits;
	}
	
	
	
}
