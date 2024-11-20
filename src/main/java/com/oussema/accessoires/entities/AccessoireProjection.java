package com.oussema.accessoires.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "libAccessoire", types = { Accessoire.class })
public interface AccessoireProjection {
	public String getLibAccessoire();

}
