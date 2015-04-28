package be.relin.eatown.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Lieux")
public class Lieux implements java.io.Serializable{

    private int id;
    
    private String country;
    private String town;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
    
}
