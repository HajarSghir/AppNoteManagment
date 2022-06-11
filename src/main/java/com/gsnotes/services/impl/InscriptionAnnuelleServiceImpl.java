package com.gsnotes.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsnotes.bo.Etudiant;
import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.IInscriptionAnnuelleDao;
import com.gsnotes.services.IInscriptionAnnuelleService;
@Service
@Transactional
public class InscriptionAnnuelleServiceImpl implements IInscriptionAnnuelleService {
    @Autowired
    private IInscriptionAnnuelleDao inscriptionDao ;

	@Override
	public List<Etudiant> getListEtudiantByNiveau(Niveau n) {
		List<InscriptionAnnuelle> liste =inscriptionDao.findAllByNiveau(n);
		List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
		liste.forEach(p->{
			listeEtudiant.add(p.getEtudiant());
			System.out.println("inscService");
		});
		return listeEtudiant;
	}

	@Override
	public InscriptionAnnuelle getInscriptionByEtudiant(Etudiant e) {
		InscriptionAnnuelle IA=inscriptionDao.getByEtudiant(e);
		return IA;
	}

}
