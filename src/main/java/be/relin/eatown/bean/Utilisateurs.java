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
@Table(name="Utilisateurs")
public class Utilisateurs implements java.io.Serializable{
	
    private int id;
    
    private String first_name;//prénom
    private String last_name;//nom
	private String username;
	private Date inscription_date;
	private String password;
	private Boolean valid;
	
	public Utilisateurs() {
	}
 
	public Utilisateurs(int id, String first_name, String last_name, String username, Date inscription_date, String password, Boolean valid) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.inscription_date = inscription_date;
		this.password = password;
		this.valid = valid;
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
	public Date getInscription_date() {
		return inscription_date;
	}

	public void setInscription_date(Date inscription_date) {
		this.inscription_date = inscription_date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}
    
}
