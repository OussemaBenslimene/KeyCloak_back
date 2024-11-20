package com.oussema.accessoires.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oussema.accessoires.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}
