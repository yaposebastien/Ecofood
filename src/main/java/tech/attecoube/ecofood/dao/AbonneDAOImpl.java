/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.attecoube.ecofood.dao;



import java.util.List;
import tech.attecoube.ecofood.dao.AbonneDAO;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.attecoube.ecofood.entity.Abonne;

/**
 *
 * @author nkeyapo
 */
@Repository
public class AbonneDAOImpl implements AbonneDAO {
    
    //Injection d'une session pour interagir avec la base de donnees
    @Autowired
    private SessionFactory sessionFactory;
 

    @Override
    public List<Abonne> getAbonnes() {
        //Obtenir la courante session
        Session currentSession = sessionFactory.getCurrentSession();
        
        //Creer une requete
        Query<Abonne> theQuery = 
                currentSession.createQuery("from Abonne ", Abonne.class);
        
        //Executer la requete et obtenir les resultats
        List<Abonne> abonnes = theQuery.getResultList();
        
        //Retourner les resultats
        return abonnes;
    }

    /*
    Pour le button ajout d'un nvel abonne
    */
    @Override
    public void saveAbonne(Abonne theAbonne) {
        
        //Obtention de la session courante
        Session currentSession = sessionFactory.getCurrentSession();
        
        //Sauvegarde du Communaute et mise a jour d'une communaute
        currentSession.saveOrUpdate(theAbonne);
    }

     //Code pour la suppression d'un abonne
    @Override
    public void deleteAbonne(int theId) {
        
        //Obtention de la courante session
        Session currentSession = sessionFactory.getCurrentSession();
        
        //Suppression de l'abonne  a partir de la cle primaire
        Query theQuery = currentSession.createQuery("delete from Abonne where id=:abonneId");
        
        theQuery.setParameter("abonneId", theId);
        
        theQuery.executeUpdate();
    }

    @Override
    public List<Abonne> searchAbonneByEmail(String theSearchAbonne) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = null;
        
        if (theSearchAbonne != null && theSearchAbonne.trim().length() > 0 ) {
            theQuery = currentSession.createQuery("from Abonne where lower(email) like :theAbonne", Abonne.class);
            theQuery.setParameter("theAbonne", "%" + theSearchAbonne.toLowerCase() + "%");
        }
        
        List<Abonne> abonnes = theQuery.getResultList();
        
        return abonnes;
    }

    @Override
    public List<Abonne> searchAbonneByTelephone(String theSearchAbonne) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = null;
        
        if (theSearchAbonne != null && theSearchAbonne.trim().length() > 0 ) {
            theQuery = currentSession.createQuery("from Abonne where lower(email) like :theAbonne", Abonne.class);
            theQuery.setParameter("theAbonne", "%" + theSearchAbonne.toLowerCase() + "%");
        }
        
        List<Abonne> abonnes = theQuery.getResultList();
        
        return abonnes;
        
        
    }
}
