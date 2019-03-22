/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.attecoube.ecofood.dao;


import tech.attecoube.ecofood.entity.Produit;
import java.util.List;

/**
 *
 * @author nkeyapo
 */
public interface ProduitDAO {

    public List<Produit> searchProduits(String theSearchName);
    
    public List<Produit> getProduits();

    public void saveProduit(Produit theProduit);

    public Produit getProduit(int theId);

    public void deleteProduit(int theId);
    
    //Adding decoration to search Produit by Vendeur
    public List<Produit> searchProduitsByVendeur(String theVendeur);
    
    //Adding decoration to search Produit by Quartier
    public List<Produit> searchProduitsByQuartier(String theQuartier);
    
    
}
