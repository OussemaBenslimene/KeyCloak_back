package com.oussema.accessoires.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Accessoire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAccessoire;
	private String libAccessoire;
	private Double prixAccessoire;
	private Date dateCreation;
	@ManyToOne
	private Marque marque;
	
	@OneToOne
	private Image image;
	
	@OneToMany (mappedBy = "accessoire")
	private List<Image> images;
	
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	public Accessoire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Accessoire(String libAccessoire, Double prixAccessoire, Date dateCreation) {
		super();
		this.libAccessoire = libAccessoire;
		this.prixAccessoire = prixAccessoire;
		this.dateCreation = dateCreation;
	}
	public Long getIdAccessoire() {
		return idAccessoire;
	}
	public void setIdAccessoire(Long idAccessoire) {
		this.idAccessoire = idAccessoire;
	}
	public String getLibAccessoire() {
		return libAccessoire;
	}
	public void setLibAccessoire(String libAccessoire) {
		this.libAccessoire = libAccessoire;
	}
	public Double getPrixAccessoire() {
		return prixAccessoire;
	}
	public void setPrixAccessoire(Double prixAccessoire) {
		this.prixAccessoire = prixAccessoire;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Accessoire [idAccessoire=" + idAccessoire + ", libAccessoire=" + libAccessoire + ", prixAccessoire="
				+ prixAccessoire + ", dateCreation=" + dateCreation + "]";
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	
	
	

}
