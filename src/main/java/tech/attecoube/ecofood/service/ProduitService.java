/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.attecoube.ecofood.service;


import java.util.List;
import tech.attecoube.ecofood.entity.Produit;

/**
 *
 * @author nkeyapo
 */
public interface ProduitService {

    public List<Produit> searchProduits(String theSearchName);
    
    public List<Produit> getProduits();
    
    //Creation methode pour sauvegarder Communaute dans le formulaire
    public void saveProduit(Produit theProduit);
    
    //Pour recuperer l'ID du produit
    public Produit getProduit(int theId);

    public void deleteProduit(int theId);
    
    //Adding decoration to search Produit by Vendeur
    public List<Produit> searchProduitsByVendeur(String theVendeur);
    
    //Adding decoration to search Produit by Quartier
    public List<Produit> searchProduitsByQuartier(String theQuartier);
    
}
