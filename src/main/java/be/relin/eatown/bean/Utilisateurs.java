package be.relin.eatown.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name="DBUSER")
public class Utilisateurs implements java.io.Serializable{
	
    private int id;
    
    private String first_name;//prénom
    private String last_name;//nom
    private String username;
	private Date inscription;
	
	public Utilisateurs() {
	}
 
	public Utilisateurs(int id, String first_name, String last_name, String username, Date inscription) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.inscription = inscription;
	}
	
	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 5, scale = 0)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "FIRST_NAME", nullable = true, length = 25)
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	@Column(name = "LAST_NAME", nullable = true, length = 25)
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Column(name = "USERNAME", unique = true, nullable = false, length = 20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "INSCRIPTION_DATE", nullable = false, length = 7)
	public Date getInscription() {
		return inscription;
	}
	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}
    
}
