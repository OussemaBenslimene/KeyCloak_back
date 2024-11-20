package com.oussema.accessoires.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.oussema.accessoires.entities.Image;
import com.oussema.accessoires.service.ImageService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	ImageService imageService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@PostMapping(value = "/uploadImageAcc/{idProd}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idProd") Long idProd)
			throws IOException {
		return imageService.uplaodImageAcc(file, idProd);
	}

	@GetMapping("/getImagesAcc/{idProd}")
	public List<Image> getImagesProd(@PathVariable("idProd") Long idProd) throws IOException {
		return imageService.getImagesParAcc(idProd);
	}

}