package be.relin.eatown.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Logo",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "FILE_NAME"),
		@UniqueConstraint(columnNames = "NAME")})
public class Logo implements java.io.Serializable{

    private int id;
	
	private String name;
	private String file_name;
	
	private Set<Resto> restos = new HashSet<Resto>(0);
	private Chaine_resto chaine_resto;
	
	public Logo() {}
	

	public Logo(int id, String name, String file_name, Set<Resto> restos,
			Chaine_resto chaine_resto) {
		super();
		this.id = id;
		this.name = name;
		this.file_name = file_name;
		this.restos = restos;
		this.chaine_resto = chaine_resto;
	}


	@Id
	@Column(name = "LOGO_ID", unique = true, nullable = false)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "logo")
	public Set<Resto> getRestos() {
		return restos;
	}

	public void setRestos(Set<Resto> restos) {
		this.restos = restos;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "logo")
	public Chaine_resto getChaine_resto() {
		return chaine_resto;
	}

	public void setChaine_resto(Chaine_resto chaine_resto) {
		this.chaine_resto = chaine_resto;
	}
	
	
}
