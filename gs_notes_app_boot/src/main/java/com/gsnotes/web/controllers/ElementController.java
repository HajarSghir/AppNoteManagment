package com.gsnotes.web.controllers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsnotes.bo.Module;
import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Element;
import com.gsnotes.bo.Etudiant;
import com.gsnotes.bo.Filiere;
import com.gsnotes.services.IElementService;
import com.gsnotes.services.IInscriptionAnnuelleService;
import com.gsnotes.services.IModuleService;
import com.gsnotes.services.INiveauService;


@Controller
@RequestMapping("/prof")
public class ElementController {
	
    @Autowired
    private IElementService elementService;
    @Autowired
	private IModuleService moduleService ;
	@Autowired
	private INiveauService niveauService ;
	 @Autowired
	private IInscriptionAnnuelleService inscriptionService ;
	
	@RequestMapping("/SessionForm")
	public String session() {
		return "/prof/SessionForm";
	}
    @RequestMapping("/SessionFormForm")
    public String index1(HttpServletRequest request , Model model) {
    	HttpSession s = request.getSession();
    	
    	String parameter = request.getParameter("session");
    	//Session = (String)session.getAttribute("session");
    	s.setAttribute("Session", parameter);
    	System.out.println(s.getAttribute("Session"));
    	List<Filiere> filieres = niveauService.getAllFiliere();
    	model.addAttribute("Filieres",filieres);
    	
    	return "/prof/ExportExcelForm" ;
    }
    
 
    @RequestMapping("/FiliereForm")
    public String index2(HttpServletResponse response,HttpServletRequest request,Model theModel) {
   
         Long id = Long.parseLong(request.getParameter("filiere")) ;
         System.out.println(id);
		 List<Niveau> Nfiliere=niveauService.listNiveauByFiliere(id);
		 theModel.addAttribute("Niveaux", Nfiliere);
		 return "/prof/ChoixNiveauForm" ;
    }
    @RequestMapping("/NiveauForm")
    public String index3(HttpServletResponse response,HttpServletRequest request,Model theModel) {
    	 Long id = Long.parseLong(request.getParameter("niveau")) ;
         System.out.println(id);
         Niveau n = niveauService.getNiveauById(id);
		 List<Module> NM=moduleService.listModuleByNiveau(n);
		 theModel.addAttribute("Modules", NM);
		 System.out.println(n.getTitre());
		 
		 return "/prof/ChoixModuleForm" ;
    }
    @SuppressWarnings("resource")
	@RequestMapping("/excelpreparation")
    public void index(HttpServletResponse response,HttpServletRequest request,Model theModel) throws FileNotFoundException , IOException{
    	Long id = Long.parseLong(request.getParameter("module")) ;
    	Module m = moduleService.getModuleById(id);
        System.out.println(m.getTitre());
        List<Element> elements = moduleService.listElements(m);
        for(int i=0;i<elements.size();i++) {
			System.out.println("Module:"+m.getTitre());
		    System.out.println("Element:"+ elements.get(i).getNom());
	    }
        HttpSession s = request.getSession();
        String session= (String) s.getAttribute("Session");
        System.out.println(session);
        
        HSSFWorkbook workbook = moduleService.prepareExport(m,session);
        response.setHeader("Content-disposition", "attachment; filename=test.xls");
		workbook.write( response.getOutputStream());
        System.out.println("excel created successfully");
      
    }
    
}
