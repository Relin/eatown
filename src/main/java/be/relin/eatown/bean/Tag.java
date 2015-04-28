package be.relin.eatown.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
}
