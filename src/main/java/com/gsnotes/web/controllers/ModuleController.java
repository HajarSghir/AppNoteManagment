package com.gsnotes.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Module;
import com.gsnotes.services.IModuleService;
import com.gsnotes.services.INiveauService;

@Controller
@RequestMapping("/test") 
public class ModuleController {
    
	@Autowired
	private IModuleService moduleService ;

	@Autowired
	private INiveauService niveauService ;
	
	@RequestMapping("/showModule")
	@ResponseBody
	public void index() {
		Long id = (long) 1 ;
		
		List<Niveau> Nfiliere=niveauService.listNiveauByFiliere(id);
		/*
		 * for(int i=0;i<Nfiliere.size();i++) {
		 * System.out.println(Nfiliere.get(i).getTitre()); }
		 */
		Nfiliere.forEach(p->{
			List<Module> NM=moduleService.listModuleByNiveau(p);
			for(int i=0;i<NM.size();i++) {
				System.out.println(p.getTitre());
				System.out.println(NM.get(i).getTitre());
			}
		});
		
	}
	
}
