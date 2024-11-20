package com.oussema.accessoires.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oussema.accessoires.entities.Accessoire;
import com.oussema.accessoires.service.AccessoireService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AccessoireRESTController {

	@Autowired
	AccessoireService accService;
	
	@GetMapping("/auth")
	Authentication getAuth(Authentication auth)
	{
		return auth;
	}


	@RequestMapping(path="all" ,method = RequestMethod.GET)
	public List<Accessoire> getAllAccessoires() {
		return accService.getAllAccessoires();
	}

	@RequestMapping(value = "/getAccessoireById/{id}", method = RequestMethod.GET)
	public Accessoire getAccessoireById(@PathVariable("id") Long id) {
		return accService.getAccessoire(id);
	}

	@RequestMapping(value="/createAccessoire" , method = RequestMethod.POST)
	public Accessoire createAccessoire(@RequestBody Accessoire accessoire) {
		return accService.saveAccessoire(accessoire);
	}

	@RequestMapping(value="/updateAccessoire" , method = RequestMethod.PUT)
	public Accessoire updateAccessoire(@RequestBody Accessoire accessoire) {
		return accService.updateAccessoire(accessoire);
	}
	@RequestMapping(value="/deleteAccessoire/{id}",method = RequestMethod.DELETE)
	public void deleteAccessoire(@PathVariable("id") Long id)
	{
		accService.deleteAccessoireById(id);
	}
	@RequestMapping(value="/accmarque/{idMar}",method = RequestMethod.GET)
	public List<Accessoire> getProduitsByCatId(@PathVariable("idMar") Long idMar) {
	return accService.findByMarqueIdMar(idMar);
	}
	@RequestMapping(value="/accsByName/{nom}",method = RequestMethod.GET)
	public List<Accessoire> findByNomProduitContains(@PathVariable("nom") String nom) {
	return accService.findByLibAccessoireContains(nom);
	}
}
