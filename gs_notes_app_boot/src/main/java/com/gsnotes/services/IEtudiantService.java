package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Etudiant;
import com.gsnotes.bo.InscriptionAnnuelle;

public interface IEtudiantService {
   public List<Etudiant> getlistEtudiantByNiveau(Niveau n);
   public InscriptionAnnuelle getLastInscriptionEtudiant(Etudiant e);
}
