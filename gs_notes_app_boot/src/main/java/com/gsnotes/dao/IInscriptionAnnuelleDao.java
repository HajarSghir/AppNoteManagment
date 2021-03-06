package com.gsnotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Etudiant;
public interface IInscriptionAnnuelleDao extends JpaRepository<InscriptionAnnuelle, Long> {
    public List<InscriptionAnnuelle> findAllByNiveau(Niveau n);
    public InscriptionAnnuelle getByEtudiant(Etudiant e);
}
