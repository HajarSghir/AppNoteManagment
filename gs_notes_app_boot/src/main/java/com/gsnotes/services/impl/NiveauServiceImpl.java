package com.gsnotes.services.impl;

import java.util.List;

import org.passay.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsnotes.bo.Filiere;
import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.IFiliereDao;
import com.gsnotes.dao.INiveauDao;
import com.gsnotes.services.INiveauService;
import com.gsnotes.utils.export.ExcelExporter;

@Service
@Transactional
public class NiveauServiceImpl implements INiveauService {

	@Autowired
	private IFiliereDao filiereDao;

	@Autowired
	private INiveauDao niveauDao;

		

	@Override
	public List<Niveau> getAllNiveau() {
		
		return niveauDao.findAll();
	}

	@Override
	public List<Filiere> getAllFiliere() {
		
		return filiereDao.findAll();
	}

	@Override
	public List<Niveau> listNiveauByFiliere(Long id) {
		Filiere f = filiereDao.getById(id);
	    List<Niveau> niveaux = niveauDao.getNiveauByFiliere(f);
		return niveaux;
	}

	@Override
	public Niveau getNiveauById(Long id) {
		Niveau n = niveauDao.getById(id);
		return n;
	}

}
