package be.relin.eatown.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Photo")
public class Photo implements java.io.Serializable{

    private int id;
	
	private String name;
	private String info;
	private Date date;
	private String file_name;
	
	private Utilisateurs utilisateur;
	private Resto resto;
	
	public Photo() {}
	
	
	public Photo(int id, String name, String info, Date date, String file_name,
			Utilisateurs utilisateur, Resto resto) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
		this.date = date;
		this.file_name = file_name;
		this.utilisateur = utilisateur;
		this.resto = resto;
	}



	@Id
	@Column(name = "PHOTO_ID", unique = true, nullable = false)
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
	
	@Column(name = "INFO", nullable = true, length = 50)
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", nullable = false, length = 7)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "FILE_NAME", nullable = false, length = 25)
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateurs utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESTO_ID", nullable = false)
	public Resto getResto() {
		return resto;
	}
	public void setResto(Resto resto) {
		this.resto = resto;
	}
	
	

	
}
