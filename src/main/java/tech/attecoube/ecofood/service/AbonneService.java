/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.attecoube.ecofood.service;


import java.util.List;
import tech.attecoube.ecofood.entity.Abonne;

/**
 *
 * @author nkeyapo
 */
public interface AbonneService {

   
    
    public List<Abonne> getAbonnes();
    
    //Creation methode pour sauvegarder Abonne dans le formulaire
    public void saveAbonne(Abonne theAbonne);
    
    //Pour recuperer l'ID du produit
    public Abonne getAbonne(int theId);

    public void deleteAbonne(int theId);
    
    //Adding decoration to search Abonne by Email
    public List<Abonne> searchAbonnesByEmail(String theAbonne);
    
    //Adding decoration to search Produit by Quartier
    public List<Abonne> searchAbonnesByTelephone(String theAbonne);
    
}
