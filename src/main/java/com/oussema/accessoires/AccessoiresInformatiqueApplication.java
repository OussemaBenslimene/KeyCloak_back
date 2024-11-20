package com.oussema.accessoires;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.oussema.accessoires.entities.Accessoire;
import com.oussema.accessoires.entities.Marque;
import com.oussema.accessoires.service.AccessoireService;

@SpringBootApplication
public class AccessoiresInformatiqueApplication implements CommandLineRunner {

	@Autowired
	AccessoireService accessoireService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(AccessoiresInformatiqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Accessoire.class ,Marque.class);
		
		
		/*accessoireService.saveAccessoire(new Accessoire("Souris Redragon M2", 160.0, new Date()));
		accessoireService.saveAccessoire(new Accessoire("Clavier Ryzer Viper", 200.0, new Date()));
		accessoireService.saveAccessoire(new Accessoire("Ecran Benq Zowie", 500.0, new Date()));
		accessoireService.saveAccessoire(new Accessoire("Casque HyperX Cloud II", 350.0, new Date()));*/
		
	}
	
	

}
