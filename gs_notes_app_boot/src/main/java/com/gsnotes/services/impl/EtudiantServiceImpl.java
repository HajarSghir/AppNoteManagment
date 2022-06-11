package com.gsnotes.services.impl;

import java.util.List;

import com.gsnotes.bo.Etudiant;
import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.Niveau;
import com.gsnotes.services.IEtudiantService;

public class EtudiantServiceImpl implements IEtudiantService {

	@Override
	public List<Etudiant> getlistEtudiantByNiveau(Niveau n) {
		
		return null;
	}

	@Override
	public InscriptionAnnuelle getLastInscriptionEtudiant(Etudiant e) {
		List<InscriptionAnnuelle> listeInscription =e.getInscriptions();
		InscriptionAnnuelle IA =listeInscription.get(listeInscription.size());
		return IA;
	}

}
