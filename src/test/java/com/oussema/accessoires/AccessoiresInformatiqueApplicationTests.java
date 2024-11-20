package com.oussema.accessoires;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.oussema.accessoires.entities.Accessoire;
import com.oussema.accessoires.entities.Marque;
import com.oussema.accessoires.repos.AccessoireRepository;
import com.oussema.accessoires.service.AccessoireService;

@SpringBootTest
class AccessoiresInformatiqueApplicationTests {

	@Autowired
	private AccessoireRepository accRepository;
	private AccessoireService accService;

	@Test
	public void testCreateAccessoire() {
		Accessoire prod = new Accessoire("Souris redragon", 100.0, new Date());
		accRepository.save(prod);
	}

	@Test
	public void testFindAccessoire() {
		Accessoire p = accRepository.findById(10L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateAccessoire() {
		Accessoire p = accRepository.findById(10L).get();
		p.setPrixAccessoire(2000.0);
		accRepository.save(p);

		System.out.println(p);
	}

	@Test
	public void testDeleteAccessoire() {
		accRepository.deleteById(10L);
	}

	@Test
	public void testFindAllAccessoires() {
		List<Accessoire> accs = accRepository.findAll();

		for (Accessoire p : accs)
			System.out.println(p);

	}

	@Test
	public void testFindByNomAccessoire() {
		List<Accessoire> accs = accRepository.findByLibAccessoire("Casque HyperX Cloud II");
		for (Accessoire p : accs) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomProduitContains() {
		List<Accessoire> accs = accRepository.findByLibAccessoireContains("Casque");
		for (Accessoire p : accs) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByLibPrix() {
		List<Accessoire> prods = accRepository.findByLibPrix("Casque HyperX Cloud II", 100.0);
		for (Accessoire p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByMarque() {
		Marque mar = new Marque();
		mar.setIdMar(1L);
		List<Accessoire> accs = accRepository.findByMarque(mar);
		for (Accessoire p : accs) {
			System.out.println(p);
		}
	}

	@Test
	public void findByMarqueIdMar() {
		List<Accessoire> accs = accRepository.findByMarqueIdMar(1L);
		for (Accessoire p : accs) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByOrderByLibAccessoireAsc() {
		List<Accessoire> accs = accRepository.findByOrderByLibAccessoireAsc();
		for (Accessoire p : accs) {
			System.out.println(p);
		}
	}

	@Test
	public void testTrierAccessoiresLibsPrixx() {
		List<Accessoire> accs = accRepository.trierAccessoiresLibsPrix();
		for (Accessoire p : accs) {
			System.out.println(p);
		}
	}

}
