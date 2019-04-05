/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.attecoube.ecofood.dao;



import java.util.List;
import tech.attecoube.ecofood.entity.Abonne;

/**
 *
 * @author nkeyapo
 */
public interface AbonneDAO {

    
    public List<Abonne> getAbonnes();

    public void saveAbonne(Abonne theAbonne);


    public void deleteAbonne(int theId);
    
    //Adding decoration to search Abonne by email
    public List<Abonne> searchAbonneByEmail(String theAbonne);
    
    //Adding decoration to search Abonne by telephone
    public List<Abonne> searchAbonneByTelephone(String theQuartier);
    
    
}
