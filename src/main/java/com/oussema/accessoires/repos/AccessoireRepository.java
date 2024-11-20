package com.oussema.accessoires.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oussema.accessoires.entities.Accessoire;
import com.oussema.accessoires.entities.Marque;

@RepositoryRestResource(path = "rest")
public interface AccessoireRepository extends JpaRepository<Accessoire , Long> {
	List<Accessoire> findByLibAccessoire(String lib);
	List<Accessoire> findByLibAccessoireContains(String lib);
	
	@Query("select p from Accessoire p where p.libAccessoire like %?1 and p.prixAccessoire > ?2")
	List<Accessoire> findByLibPrix (String lib, Double prix);
	
	@Query("select p from Accessoire p where p.libAccessoire like %:lib and p.prixAccessoire > :prix")
	List<Accessoire> findByNomPrix (@Param("lib") String lib,@Param("prix") Double prix);
	
	@Query("select p from Accessoire p where p.marque = ?1")
	List<Accessoire> findByMarque (Marque marque);
	
	List<Accessoire> findByMarqueIdMar(Long id);
	
	List<Accessoire> findByOrderByLibAccessoireAsc();
	
	@Query("select p from Accessoire p order by p.libAccessoire ASC, p.prixAccessoire DESC")
	List<Accessoire> trierAccessoiresLibsPrix ();


}
