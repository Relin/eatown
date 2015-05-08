package be.relin.eatown.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Tag")
public class Tag implements java.io.Serializable{

	/* Les tags
	 * --------
	 * 
	 * Les tag son des données a ajouter au resto,
	 * style "pizzeria", "kebab" et autre mais également
	 * "pas chere", "sain" - donc tous ce qui peut
	 * différencier un resto d'un autre */
	
	
    private int id;
	
	private String name;
	
	private Set<Resto> restos = new HashSet<Resto>(0);
	
	public Tag() {}
	
	public Tag(int id, String name, Set<Resto> restos) {
		super();
		this.id = id;
		this.name = name;
		this.restos = restos;
	}



	@Id
	@Column(name = "TAG_ID", unique = true, nullable = false)
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

	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "RESTO_TAG",
			joinColumns = { @JoinColumn(name = "TAG_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "RESTO_ID", nullable = false, updatable = false) })
	public Set<Resto> getRestos() {
		return restos;
	}
	public void setRestos(Set<Resto> restos) {
		this.restos = restos;
	}
	
	
	
}
