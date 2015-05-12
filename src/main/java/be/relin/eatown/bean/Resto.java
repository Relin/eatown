package be.relin.eatown.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Resto")
public class Resto implements java.io.Serializable{

    private int id;
	
	private String name;
	private String address;
	private String tel;
	private String www;
	private String description;
	private Date last_verif;
	
	private Set<Commentaire> commentaires = new HashSet<Commentaire>(0);
	private Set<Utilisateurs> liked = new HashSet<Utilisateurs>(0);
	private Set<Tag> taged = new HashSet<Tag>(0);
	private Logo logo;
	private Chaine_resto chaine_resto;
	private Town town;
	private Set<Photo> photos = new HashSet<Photo>(0);
	
	
	public Resto() {}
	

	public Resto(int id, String name, String address, String tel, String www,
			String description, Date last_verif, Set<Commentaire> commentaires,
			Set<Utilisateurs> liked, Set<Tag> taged, Logo logo,
			Chaine_resto chaine_resto, Town town, Set<Photo> photos) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.www = www;
		this.description = description;
		this.last_verif = last_verif;
		this.commentaires = commentaires;
		this.liked = liked;
		this.taged = taged;
		this.logo = logo;
		this.chaine_resto = chaine_resto;
		this.town = town;
		this.photos = photos;
	}

	
	@Id
	@Column(name = "RESTO_ID", unique = true, nullable = false)
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
	
	@Column(name = "ADDRESS", nullable = false, length = 25)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "TEL", nullable = true, length = 25)
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Column(name = "WWW", nullable = true, length = 100)
	public String getWww() {
		return www;
	}
	public void setWww(String www) {
		this.www = www;
	}
	
	@Column(name = "DESCRIPTION", nullable = true, length = 100)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_VERIF", nullable = false, length = 7)
	public Date getLast_verif() {
		return last_verif;
	}
	public void setLast_verif(Date last_verif) {
		this.last_verif = last_verif;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resto")
	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_RESTO",
			joinColumns = { @JoinColumn(name = "RESTO_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) })
	public Set<Utilisateurs> getLiked() {
		return liked;
	}
	public void setLiked(Set<Utilisateurs> liked) {
		this.liked = liked;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "RESTO_TAG",
			joinColumns = { @JoinColumn(name = "RESTO_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "TAG_ID", nullable = false, updatable = false) })
	public Set<Tag> getTaged() {
		return taged;
	}
	public void setTaged(Set<Tag> taged) {
		this.taged = taged;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOGO", nullable = true)
	public Logo getLogo() {
		return logo;
	}
	public void setLogo(Logo logo) {
		this.logo = logo;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHAINE_RESTO", nullable = true)
	public Chaine_resto getChaine_resto() {
		return chaine_resto;
	}
	public void setChaine_resto(Chaine_resto chaine_resto) {
		this.chaine_resto = chaine_resto;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TOWN", nullable = true)
	public Town getTown() {
		return town;
	}
	public void setTown(Town town) {
		this.town = town;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resto")
	public Set<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	
	
	/* Methode */
	public static List<Resto> recuperationResto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static boolean CheckPhone(String num) {
		boolean result = false;
		String numRefined= num.replaceAll("[^0-9]", "");//supprime tout ce qui n'est pas un chiffre.
		if(numRefined.length()<13 && numRefined.length()>8) //test sur la taille du numéro de téléphone - peut etre rajouter un regex.
			result = true;
		return result;
	}
	
	
}
