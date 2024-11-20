package com.oussema.accessoires.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.oussema.accessoires.entities.Marque;


@RepositoryRestResource(path = "mar")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface MarqueRepository extends JpaRepository<Marque, Long> {
	
}