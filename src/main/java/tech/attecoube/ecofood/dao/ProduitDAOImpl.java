/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.attecoube.ecofood.dao;


import tech.attecoube.ecofood.entity.Produit;
import java.util.List;
import tech.attecoube.ecofood.dao.ProduitDAO;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nkeyapo
 */
@Repository
public class ProduitDAOImpl implements ProduitDAO {
    
    //Injection d'une session pour interagir avec la base de donnees
    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    //@Transactional //Permet Spring de gerer la debut et la fin de la transaction
    public List<Produit> getProduits() {
        
        //Obtenir la courante session
        Session currentSession = sessionFactory.getCurrentSession();
        
        //Creer une requete
        Query<Produit> theQuery = 
                currentSession.createQuery("from Produit P order by P.produit_date_peremption asc  ", Produit.class);
        
        //Executer la requete et obtenir les resultats
        List<Produit> produits = theQuery.getResultList();


       
        
        //Retourner les resultats
        return produits;
    }

    /*
    Pour le button ajout d'une nvelle produit
    */
    @Override
    public void saveProduit(Produit theProduit) {
        
        //Obtention de la session courante
        Session currentSession = sessionFactory.getCurrentSession();
        
        //Sauvegarde du Communaute et mise a jour d'une communaute
        currentSession.saveOrUpdate(theProduit);
        
    }
    
    //Code pour la modification d'une communaute
   @Override
   public Produit getProduit(int theId) {
       
    //Recuperer la session courante
    Session currentSession = sessionFactory.getCurrentSession();
    
    //Recuperer la Communaute 
    Produit theProduit = currentSession.get(Produit.class, theId);
    
    return theProduit;
    
   }
   
   //Code pour la suppression d'une communaute

    @Override
    public void deleteProduit(int theId) {
        
        //Obtention de la courante session
        Session currentSession = sessionFactory.getCurrentSession();
        
        //Suppression de la communaute a partir de la cle primaire
        Query theQuery = currentSession.createQuery("delete from Produit where id=:produitId");
        
        theQuery.setParameter("produitId", theId);
        
        theQuery.executeUpdate();
    }
   
    //Code pour la recherche d'une communaute
    @Override
    public List<Produit> searchProduits(String theSearchName) {
        
        //Obtention de la session courante
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //Effectue la recherche si theSearchName est non vide
        if (theSearchName!= null && theSearchName.trim().length() > 0) {
            
            //Le critere de recherche est le nom de la communaute
            theQuery = currentSession.createQuery("from Produit where lower(produit_vendeur) like :theName",Produit.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%" );
        
        }
        else {
            //Retourner la liste de toutes les communautes si le resultat est null
            theQuery = currentSession.createQuery("from Produit",Produit.class);
            
        }
        
        //Excecution de la requete et affichage des resultats
        List<Produit> produits = theQuery.getResultList();
        
        return produits;
        
    }
    
    
    //Adding decoration to search Produit by Vendeur
    @Override
    public List<Produit> searchProduitsByVendeur(String theSearchVendeur) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = null;
        
        if (theSearchVendeur != null && theSearchVendeur.trim().length() > 0 ) {
            theQuery = currentSession.createQuery("from Produit where lower(produit_vendeur) like :theVendeur", Produit.class);
            theQuery.setParameter("theVendeur", "%" + theSearchVendeur.toLowerCase() + "%");
        }
        
        List<Produit> produits = theQuery.getResultList();
        
        return produits;
    }
    
    //Adding decoration to search Produit by Quartier
    @Override
    public List<Produit> searchProduitsByQuartier(String theSearchQuartier) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = null;
        
        if (theSearchQuartier != null && theSearchQuartier.trim().length() > 0 ) {
            theQuery = currentSession.createQuery("from Produit where lower(produit_vendeur_quartier) like :theQuartier", Produit.class);
            theQuery.setParameter("theQuartier", "%" + theSearchQuartier.toLowerCase() + "%");
        }
        
        List<Produit> produits = theQuery.getResultList();
        
        return produits;
    }
}
