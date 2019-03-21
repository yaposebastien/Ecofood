/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.attecoube.ecofood.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author nkeyapo
 */
@Entity
@Table(name="produit")
public class Produit {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
   
   @Column(name="produit_nom") 
   private String produit_nom;
   
   @Column(name="produit_type") 
   private String produit_type;
   
   @Column(name="produit_quantite") 
   private int produit_quantite;
  
   @Column(name="produit_date_peremption") 
   private Date produit_date_peremption;
   
   @Column(name="produit_prix_normal") 
   private int produit_prix_normal;
   
   @Column(name="produit_prix_promotion") 
   private int produit_prix_promotion;
   
   @Column(name="date_soumission") 
   private Date date_soumission;
   
   @Column(name="produit_vendeur") 
   private String produit_vendeur;
    
   @Column(name="produit_vendeur_telephone") 
   private String produit_vendeur_telephone;
     
   @Column(name="produit_vendeur_quartier") 
   private String produit_vendeur_quartier;
  
   
    
   //Insert Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduit_nom() {
        return produit_nom;
    }

    public void setProduit_nom(String produit_nom) {
        this.produit_nom = produit_nom;
    }

    public String getProduit_type() {
        return produit_type;
    }

    public void setProduit_type(String produit_type) {
        this.produit_type = produit_type;
    }

    public int getProduit_quantite() {
        return produit_quantite;
    }

    public void setProduit_quantite(int produit_quantite) {
        this.produit_quantite = produit_quantite;
    }

    public Date getProduit_date_peremption() {
        return produit_date_peremption;
    }

    public void setProduit_date_peremption(Date produit_date_peremption) {
        this.produit_date_peremption = produit_date_peremption;
    }

    public int getProduit_prix_normal() {
        return produit_prix_normal;
    }

    public void setProduit_prix_normal(int produit_prix_normal) {
        this.produit_prix_normal = produit_prix_normal;
    }

    public int getProduit_prix_promotion() {
        return produit_prix_promotion;
    }

    public void setProduit_prix_promotion(int produit_prix_promotion) {
        this.produit_prix_promotion = produit_prix_promotion;
    }

    public Date getDate_soumission() {
        return date_soumission;
    }

    public void setDate_soumission(Date date_soumission) {
        this.date_soumission = date_soumission;
    }

    public String getProduit_vendeur() {
        return produit_vendeur;
    }

    public void setProduit_vendeur(String produit_vendeur) {
        this.produit_vendeur = produit_vendeur;
    }

    public String getProduit_vendeur_telephone() {
        return produit_vendeur_telephone;
    }

    public void setProduit_vendeur_telephone(String produit_vendeur_telephone) {
        this.produit_vendeur_telephone = produit_vendeur_telephone;
    }

    public String getProduit_vendeur_quartier() {
        return produit_vendeur_quartier;
    }

    public void setProduit_vendeur_quartier(String produit_vendeur_quartier) {
        this.produit_vendeur_quartier = produit_vendeur_quartier;
    }

    

    
   
   
}
