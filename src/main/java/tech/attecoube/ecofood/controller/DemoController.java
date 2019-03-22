package tech.attecoube.ecofood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import javax.validation.Valid;
import tech.attecoube.ecofood.dao.ProduitDAO;
import tech.attecoube.ecofood.entity.Produit;
import tech.attecoube.ecofood.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
    
    //Injection de notre Service pour le Produit
       @Autowired
       private ProduitService produitService;

	@GetMapping("/")
	public String showHome(Model theModel) {
            
           
        //Obtenir la liste des Produits de notre Service
        List<Produit> theProduits = produitService.getProduits();
        
        //Ajout de Produits au Model
        theModel.addAttribute("produits", theProduits);
		
		return "home";
	}
        
	
	// add request mapping for administrator /admin

	@GetMapping("/admin")
	public String showAdmins() {
		
		return "admins";
	}

        //Code pour rechercher les produits d'un vendeur
        @PostMapping("search")
        public String searchProduitsByVendeur(@RequestParam("theSearchName") 
                String theSearchName, Model theModel) {

            //Recherche de la communaute dans notre service

            List<Produit> theProduits = produitService.searchProduitsByVendeur(theSearchName);

            //Ajout des communautes dans le modele
            theModel.addAttribute("produits", theProduits);

            return "home";
        
    }
        
        
        
	

	
}










