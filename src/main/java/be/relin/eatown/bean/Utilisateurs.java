package be.relin.eatown.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Utilisateurs", uniqueConstraints = {
		@UniqueConstraint(columnNames = "USERNAME") })
public class Utilisateurs implements java.io.Serializable{
	
    private int id;
    
    private String first_name;//prénom
    private String last_name;//nom
	private String username;
	private Date inscription_date;
	private String password;
	private boolean valide;   //If annotation doesn't work try to replace boolean by int
	//private int valid;      //Solving mapping problem by 1 true and 0 false
	
	private Set<Group> group = new HashSet<Group>(0);
	private Avatar avatar;
	private Set<Commentaire> commentaires = new HashSet<Commentaire>(0);
	private Set<Resto> like = new HashSet<Resto>(0);
	
	/*Constructeur*/
	public Utilisateurs() {
	}


	public Utilisateurs(int id, String first_name, String last_name,
			String username, Date inscription_date, String password,
			boolean valide, Set<Group> group, Avatar avatar,
			Set<Commentaire> commentaires, Set<Resto> like) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.inscription_date = inscription_date;
		this.password = password;
		this.valide = valide;
		this.group = group;
		this.avatar = avatar;
		this.commentaires = commentaires;
		this.like = like;
	}


	/*Get/set*/
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
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

	@Column(name = "PASSWORD", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "U_VALID", nullable = false)
	@Type(type ="org.hibernate.type.BooleanType")
	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateurs")
	public Set<Group> getGroup() {
		return group;
	}

	public void setGroup(Set<Group> group) {
		this.group = group;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVATAR_ID", nullable = false)
	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_RESTO",
			joinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) })
	public Set<Resto> getLike() {
		return like;
	}

	public void setLike(Set<Resto> like) {
		this.like = like;
	}
	
	
	
}
