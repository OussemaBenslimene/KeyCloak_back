package com.oussema.accessoires.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oussema.accessoires.entities.Accessoire;
import com.oussema.accessoires.service.AccessoireService;


@Controller
public class AccessoireController {
	@Autowired
	AccessoireService accessoireService;

	@RequestMapping("/myview")
	public String myView() {
		return "myView";
	}

	@RequestMapping("/ListeAccessoires")
	public String listeProduits(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Accessoire> acc = accessoireService.getAllAccessoiresParPage(page, size);
		modelMap.addAttribute("accessoires", acc);
		modelMap.addAttribute("pages", new int[acc.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeAccessoires";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createAccessoire";
	}

	@RequestMapping("/saveAccessoire")
	public String saveAccessoire(@ModelAttribute("produit") Accessoire accessoire, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		accessoire.setDateCreation(dateCreation);

		Accessoire saveProduit = accessoireService.saveAccessoire(accessoire);
		String msg = "Accessoire enregistré avec Id " + saveProduit.getIdAccessoire();
		modelMap.addAttribute("msg", msg);
		return "createAccessoire";
	}

	@RequestMapping("/supprimerAccessoire")
	public String supprimerAccessoire(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		accessoireService.deleteAccessoireById(id);
		Page<Accessoire> acc = accessoireService.getAllAccessoiresParPage(page, size);
		modelMap.addAttribute("accessoires", acc);
		modelMap.addAttribute("pages", new int[acc.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeAccessoires";
	}

	@RequestMapping("/modifierAccessoire")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap) {
		Accessoire p = accessoireService.getAccessoire(id);
		modelMap.addAttribute("accessoire", p);
		return "editerAccessoire";
	}

	@RequestMapping("/updateAccessoire")
	public String updateProduit(@ModelAttribute("accessoire") Accessoire accessoire, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		accessoire.setDateCreation(dateCreation);

		accessoireService.updateAccessoire(accessoire);
		List<Accessoire> prods = accessoireService.getAllAccessoires();
		modelMap.addAttribute("produits", prods);
		return "listeAccessoires";
	}

}
