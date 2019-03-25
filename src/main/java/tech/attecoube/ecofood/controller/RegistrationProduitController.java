/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.attecoube.ecofood.controller;


import tech.attecoube.ecofood.entity.Produit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.attecoube.ecofood.dao.ProduitDAO;
import tech.attecoube.ecofood.service.ProduitService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nkeyapo
 */
@Controller
@RequestMapping("/produit")
public class RegistrationProduitController {
    
    //Injection de notre Service pour le Communaute
    @Autowired
    private ProduitService produitService;
    
    @GetMapping("/list")
    public String listProduits(Model theModel) {
        
        //Obtenir la liste des Customers de notre Service
        List<Produit> theProduits = produitService.getProduits();
        
        //Ajout de Produits au Model
        theModel.addAttribute("produits", theProduits);
        
        return "list-produits";
    }
    
    //Ajout pour le formulaire
    @GetMapping("/formulaireCreationProduit")
    public String showFormForAdd(Model theModel) {
        
        //Ajout de l'objet Communaute
        Produit theProduit = new Produit();
        
        //Ajout de l'instance de l'objet au Model 
        theModel.addAttribute("produit", theProduit);
        
        return "registration-produit-form";
    }
    
    /*
    Ajout du code du bouton Ajout Communaute, donner le nom donne action dans le 
    formulaire.
    Passe aussi le nom du model donne dans notre formulaire
    */
    @PostMapping("saveProduit")
    public String saveProduit(@ModelAttribute("produit") Produit theProduit) {
        
    //Sauvegarde de notre Communaute
    produitService.saveProduit(theProduit);
    
        return "registration-produit-confirmation";
    }
    
    /*
    Portion de code pour la mise a jour d'une communaute
    */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("produitId") int theId,
                                    Model theModel) {
        
        //Recuperer notre communaute dans l'interface service
        Produit theProduit = produitService.getProduit(theId);
        
        //Remplissage du formualire avec les donnees de la communaute selectionnee
        theModel.addAttribute("produit", theProduit);
        
        return "registration-produit-form";
    }
    
    /*
    Code pour supprimer une communaute
    */
    @GetMapping("/delete")
    public String deletProduit(@RequestParam("produitId") int theId) {
        
        //Suppression de la communaute
       produitService.deleteProduit(theId);
        return "redirect:/";
    }
    
    //Code pour rechercher une communaute
    @PostMapping("search")
    public String searchProduit(@RequestParam("theSearchName") 
            String theSearchName, Model theModel) {
        
        //Recherche de la communaute dans notre service
        List<Produit> theProduits = produitService.searchProduits(theSearchName);
        
        //Ajout des communautes dans le modele
        theModel.addAttribute("produits", theProduits);
        
        return "list-produits";
        
    }
    
}
