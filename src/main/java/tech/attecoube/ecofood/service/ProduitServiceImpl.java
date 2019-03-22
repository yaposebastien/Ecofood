/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.attecoube.ecofood.service;


import tech.attecoube.ecofood.entity.Produit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.attecoube.ecofood.dao.ProduitDAO;



/**
 *
 * @author nkeyapo
 */
@Service
public class ProduitServiceImpl implements ProduitService {
    
    
    //Injection of Communaute DAO
    @Autowired
    private ProduitDAO produitDAO;
    
    
    @Override
    @Transactional
    public List<Produit> getProduits() {
        
        return produitDAO.getProduits();
    }

    //Ajout du code pour sauvegarder le produit
    @Override
    @Transactional
    public void saveProduit(Produit theProduit) {
       produitDAO.saveProduit(theProduit);
    }
    
    //Ajout du code pour la mise a jour de la communaute
    @Override
    @Transactional
    public Produit getProduit(int theId) {
        
        return produitDAO.getProduit(theId);
    }
    
    //Ajout du code pour la suppression

    @Override
    @Transactional
    public void deleteProduit(int theId) {
         
       produitDAO.deleteProduit(theId); 
        
    }
    
    //Ajout de la methode d'implementation de la recherche
    @Override
    @Transactional
    public List<Produit> searchProduits(String theSearchName) {
        
        return produitDAO.searchProduits(theSearchName);
    }
    
    //Adding decoration to search Produit by Vendeur
    @Override
    @Transactional
    public List<Produit> searchProduitsByVendeur(String theVendeur) {
        return produitDAO.searchProduitsByVendeur(theVendeur);
    }
    
    
   //Adding decoration to search Produit by Quartier
    @Override
    @Transactional
    public List<Produit> searchProduitsByQuartier(String theQuartier) {
        return produitDAO.searchProduitsByQuartier(theQuartier);
    }
    
}
