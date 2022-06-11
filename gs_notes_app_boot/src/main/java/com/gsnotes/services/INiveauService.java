package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Filiere;
import com.gsnotes.bo.Niveau;



public interface INiveauService {
	
	public List<Niveau> getAllNiveau();
	
	public List<Filiere> getAllFiliere();
	
	public Niveau getNiveauById(Long id);
	
	public List<Niveau> listNiveauByFiliere(Long id);

}
