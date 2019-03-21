package tech.attecoube.ecofood.user;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import tech.attecoube.ecofood.validation.FieldMatch;
import tech.attecoube.ecofood.validation.ValidEmail;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class BoutiqueUser {

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String userName;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String matchingPassword;

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

	public BoutiqueUser() {

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

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
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

       

	
}
