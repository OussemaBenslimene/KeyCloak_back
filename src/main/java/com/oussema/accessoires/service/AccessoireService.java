package com.oussema.accessoires.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.oussema.accessoires.entities.Accessoire;
import com.oussema.accessoires.entities.Marque;

public interface AccessoireService {
	Accessoire saveAccessoire(Accessoire p);

	Accessoire updateAccessoire(Accessoire p);

	void deleteAccessoire(Accessoire p);

	void deleteAccessoireById(Long id);

	Accessoire getAccessoire(Long id);

	List<Accessoire> getAllAccessoires();

	Page<Accessoire> getAllAccessoiresParPage(int page, int size);
	
	List<Accessoire> findByLibAccessoire(String lib);
	List<Accessoire> findByLibAccessoireContains(String lib);
	List<Accessoire> findByLibPrix (String lib, Double prix);
	List<Accessoire> findByMarque (Marque marque);
	List<Accessoire> findByMarqueIdMar(Long id);
	List<Accessoire> findByOrderByLibAccessoireAsc();
	List<Accessoire> trierAccessoiresLibsPrix();

}
