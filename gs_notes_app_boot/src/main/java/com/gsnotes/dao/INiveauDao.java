package com.gsnotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.Filiere;
import com.gsnotes.bo.Niveau;

public interface INiveauDao extends JpaRepository<Niveau, Long> {
	public List<Niveau> getNiveauByFiliere(Filiere f);
}
