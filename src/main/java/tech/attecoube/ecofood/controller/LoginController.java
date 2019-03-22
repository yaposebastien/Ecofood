package tech.attecoube.ecofood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import tech.attecoube.ecofood.dao.ProduitDAO;
import tech.attecoube.ecofood.entity.Produit;
import tech.attecoube.ecofood.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
       //Injection de notre Service pour le Produit
       @Autowired
       private ProduitService produitService;

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage(Model theModel) {
            
        //Obtenir la liste des Produits de notre Service
        List<Produit> theProduits = produitService.getProduits();
        
        //Ajout de Produits au Model
        theModel.addAttribute("produits", theProduits);
		return "Login_Page";
		
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
        
        
         //Code pour rechercher les produits d'un vendeur
        @PostMapping("/searchProduit")
        public String searchProduitsByQuartier(@RequestParam("theSearchName") 
                String theSearchName, Model theModel) {

            //Recherche de la communaute dans notre service

            List<Produit> theProduits = produitService.searchProduitsByQuartier(theSearchName);

            //Ajout des communautes dans le modele
            theModel.addAttribute("produits", theProduits);

            return "Login_Page";
        }
        
       
}









