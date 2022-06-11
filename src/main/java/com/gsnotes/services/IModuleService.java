package com.gsnotes.services;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Utilisateur;
import com.gsnotes.bo.Module;
import com.gsnotes.bo.Element;
public interface IModuleService {
	
    public List<Module> getAllModule();
    
    public Module getModuleById(Long id);
    
    public List<Module> listModuleByNiveau(Niveau n);
    
    public List<Element> listElements(Module m);
    
	HSSFWorkbook prepareExport(Module m,String s);
}
