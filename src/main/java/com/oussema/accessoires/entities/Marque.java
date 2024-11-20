package com.oussema.accessoires.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMar;
	private String nomMar;
	private String descriptionMar;
	
	@JsonIgnore
	@OneToMany(mappedBy = "marque")
	private List<Accessoire> accessoires;


}
