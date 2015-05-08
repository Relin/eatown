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
@Table(name="Commentaire")
public class Commentaire implements java.io.Serializable{
	
    private int id;
    
    private int note;
    private String text;
    private Date date;
    
    private Utilisateurs utilisateur;
    private Resto resto;
    
    public Commentaire() {}
    
    public Commentaire(int id, int note, String text, Date date,
			Utilisateurs utilisateur, Resto resto) {
		super();
		this.id = id;
		this.note = note;
		this.text = text;
		this.date = date;
		this.utilisateur = utilisateur;
		this.resto = resto;
	}

	@Id
	@Column(name = "COMMENTAIRE_ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	@Column(name = "NOTE", nullable = false)
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	
	@Column(name = "TEXT", nullable = false)
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", nullable = false, length = 7)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
