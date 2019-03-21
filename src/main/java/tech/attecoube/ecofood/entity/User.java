package tech.attecoube.ecofood.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "nom_boutique")
	private String nom_boutique;
        
        @Column(name = "nom_proprietaire_boutique")
	private String nom_proprietaire_boutique;

	@Column(name = "telephone_boutique")
	private String telephone_boutique;

	@Column(name = "email_boutique")
	private String email_boutique;
        
        @Column(name = "quartier_boutique")
	private String quartier_boutique;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public User() {
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom_boutique() {
        return nom_boutique;
    }

    public void setNom_boutique(String nom_boutique) {
        this.nom_boutique = nom_boutique;
    }

    public String getNom_proprietaire_boutique() {
        return nom_proprietaire_boutique;
    }

    public void setNom_proprietaire_boutique(String nom_proprietaire_boutique) {
        this.nom_proprietaire_boutique = nom_proprietaire_boutique;
    }

    public String getTelephone_boutique() {
        return telephone_boutique;
    }

    public void setTelephone_boutique(String telephone_boutique) {
        this.telephone_boutique = telephone_boutique;
    }

    public String getEmail_boutique() {
        return email_boutique;
    }

    public void setEmail_boutique(String email_boutique) {
        this.email_boutique = email_boutique;
    }

    public String getQuartier_boutique() {
        return quartier_boutique;
    }

    public void setQuartier_boutique(String quartier_boutique) {
        this.quartier_boutique = quartier_boutique;
    }

    
        
        
        

	public User(String userName, String password, String nom_boutique, String nom_proprietaire_boutique, String telephone_boutique, String email_boutique, String quartier_boutique) {
		this.userName = userName;
		this.password = password;
                this.nom_boutique = nom_boutique;
                this.nom_proprietaire_boutique = nom_proprietaire_boutique;
                this.telephone_boutique = telephone_boutique;
                this.email_boutique = email_boutique;
                this.quartier_boutique = quartier_boutique;
		
	}

	public User(String userName, String password, String nom_boutique, String nom_proprietaire_boutique, String telephone_boutique, String email_boutique, String quartier_boutique,
			Collection<Role> roles) {
		this.userName = userName;
		this.password = password;
		this.nom_boutique = nom_boutique;
                this.nom_proprietaire_boutique = nom_proprietaire_boutique;
                this.telephone_boutique = telephone_boutique;
                this.email_boutique = email_boutique;
                this.quartier_boutique = quartier_boutique;
		this.roles = roles;
	}

	
	

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", nom_boutique=" + nom_boutique + ", nom_proprietaire_boutique=" + nom_proprietaire_boutique + ", telephone_boutique=" + telephone_boutique + ", email_boutique=" + email_boutique + ", quartier_boutique=" + quartier_boutique + ", roles=" + roles + '}';
    }

        
    

	
}
