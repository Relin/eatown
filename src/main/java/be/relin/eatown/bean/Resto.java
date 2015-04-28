package be.relin.eatown.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Resto")
public class Resto implements java.io.Serializable{

    private int id;
	
	private String name;
	private String address;
	private String tel;
	private String www;
	private String description;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getWww() {
		return www;
	}
	public void setWww(String www) {
		this.www = www;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public static List<Resto> recuperationResto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static boolean CheckPhone(String num) {
		boolean result = false;
		String numRefined= num.replaceAll("[^0-9]", "");//suprime tout ce qui n'est pas un chiffre.
		if(numRefined.length()<13 && numRefined.length()>8) //test sur la taille du numéro de téléphone - peut etre rajouter un regex.
			result = true;
		return result;
	}
	
	
}
