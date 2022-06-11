package com.gsnotes.web.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsnotes.bo.Compte;
import com.gsnotes.bo.Filiere;
import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.INiveauDao;
import com.gsnotes.services.ICompteService;
import com.gsnotes.services.INiveauService;
import com.gsnotes.services.IPersonService;
import com.gsnotes.utils.export.ExcelExporter;
import com.gsnotes.web.models.AccountModel;


@Controller
@RequestMapping("/test") 

public class NiveauController {

	@Autowired
	private INiveauService niveauService;
	
	@RequestMapping("/showNiveau")
	@ResponseBody
    public void index() {
		/*
		 * List<Niveau> niveaux=niveauService.getAllNiveau(); for(int
		 * i=0;i<niveaux.size();i++) { System.out.println("test");
		 * System.out.println(niveaux.get(i).getTitre()); }
		 */
		Long id = (long) 1 ;
		List<Niveau> Nfiliere=niveauService.listNiveauByFiliere(id);
		for(int i=0;i<Nfiliere.size();i++) {
			System.out.println(Nfiliere.get(i).getTitre());
		}
	 }
	
}
//@GetMapping("/showNiveau")
//public String showAllNiveau(Model theModel) {
//	List<Niveau> niveaux=niveauService.getAllNiveau();
//	System.out.println(niveaux);
//	theModel.addAttribute("niveaux",niveaux);
//	return "listNiveaux";
//}