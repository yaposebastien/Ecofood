package tech.attecoube.ecofood.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.attecoube.ecofood.entity.Abonne;
import tech.attecoube.ecofood.service.AbonneService;



@Controller
@RequestMapping("/abonne")
public class RegistrationAbonneController {
    
    
	
    @Autowired
    private AbonneService abonneService;
	
    private Logger logger = Logger.getLogger(getClass().getName());
    
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/formulaireCreationAbonne")
	public String AffichageCreationAbonne(Model theModel) {
            
          
		
		theModel.addAttribute("boutiqueAbonne", new Abonne());
		
		return "registration-abonne-form";
	}

	@PostMapping("/saveAbonne")
	public String saveAbonne( @ModelAttribute("abonne") Abonne theAbonne) {
		
            //Sauvegarde de notre abonne
            abonneService.saveAbonne(theAbonne);
            
            return "Login_Page";
			
        }
     
}
