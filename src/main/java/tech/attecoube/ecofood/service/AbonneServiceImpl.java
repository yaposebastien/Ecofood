/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.attecoube.ecofood.service;


import tech.attecoube.ecofood.entity.Abonne;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.attecoube.ecofood.dao.AbonneDAO;



/**
 *
 * @author nkeyapo
 */
@Service
public class AbonneServiceImpl implements AbonneService {
    
    
    //Injection of Communaute DAO
    @Autowired
    private AbonneDAO abonneDAO;
    
    
    @Override
    @Transactional
    public List<Abonne> getAbonnes() {
        
        return abonneDAO.getAbonnes();
    }

    //Ajout du code pour sauvegarder le produit
    @Override
    @Transactional
    public void saveAbonne(Abonne theAbonne) {
       abonneDAO.saveAbonne(theAbonne);
    }
    
  
    
    //Ajout du code pour la suppression

    @Override
    @Transactional
    public void deleteAbonne(int theId) {
         
       abonneDAO.deleteAbonne(theId); 
        
    }
    
  
    
    //Adding decoration to search Abonne by Email
    @Override
    @Transactional
    public List<Abonne> searchAbonnesByEmail(String theAbonne) {
        return abonneDAO.searchAbonneByEmail(theAbonne);
    }
    
    
   //Adding decoration to search Produit by Quartier
    @Override
    @Transactional
    public List<Abonne> searchAbonnesByTelephone(String theAbonne) {
        return abonneDAO.searchAbonneByTelephone(theAbonne);
    }

    @Override
    public Abonne getAbonne(int theId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
