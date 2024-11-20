package com.oussema.accessoires.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.oussema.accessoires.entities.Image;
public interface ImageService {
	
 Image uplaodImage(MultipartFile file) throws IOException;
 Image getImageDetails(Long id) throws IOException;
 ResponseEntity<byte[]> getImage(Long id) throws IOException;
 void deleteImage(Long id) ;
 
 Image uplaodImageAcc(MultipartFile file,Long idProd) throws IOException;
 List<Image> getImagesParAcc(Long accId);
}
