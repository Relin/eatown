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

import org.hibernate.annotations.Type;

@Entity
@Table(name="Avatar",
		uniqueConstraints = {
			@UniqueConstraint(columnNames = "FILE_NAME"),
			@UniqueConstraint(columnNames = "NAME")})
public class Avatar implements java.io.Serializable{

    private int id;
	
	private String name;
	private String file_name;
	private boolean from_user; //Si oui elle peux etre supprimer
	
	private Set<Utilisateurs> utilisateurs = new HashSet<Utilisateurs>(0);
	private Set<Group> group = new HashSet<Group>(0);
	
	public Avatar() {}
	
	public Avatar(int id, String name, String file_name, boolean from_user,
			Set<Utilisateurs> utilisateurs, Set<Group> group) {
		super();
		this.id = id;
		this.name = name;
		this.file_name = file_name;
		this.from_user = from_user;
		this.utilisateurs = utilisateurs;
		this.group = group;
	}

	
	@Id
	@Column(name = "AVATAR_ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	@Column(name = "NAME", nullable = true, length = 25)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "FILE_NAME", nullable = false, length = 25)
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	@Column(name = "FROM_USER", nullable = false, columnDefinition="boolean default true")
	@Type(type ="org.hibernate.type.BooleanType")
	public boolean isFrom_user() {
		return from_user;
	}
	public void setFrom_user(boolean from_user) {
		this.from_user = from_user;
	}
	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "avatar")
	public Set<Utilisateurs> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Set<Utilisateurs> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "avatar")
	public Set<Group> getGroup() {
		return group;
	}
	public void setGroup(Set<Group> group) {
		this.group = group;
	}
	
	
}