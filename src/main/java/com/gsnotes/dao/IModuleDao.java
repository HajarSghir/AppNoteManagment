package com.gsnotes.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Module;
public interface IModuleDao extends JpaRepository<Module, Long> {
	public List<Module> findAllByNiveau(Niveau n);
}
