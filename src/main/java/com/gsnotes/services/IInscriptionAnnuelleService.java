package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Etudiant;
import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Etudiant;
public interface IInscriptionAnnuelleService {
    public List<Etudiant> getListEtudiantByNiveau(Niveau n);
    public InscriptionAnnuelle getInscriptionByEtudiant(Etudiant e);
}
