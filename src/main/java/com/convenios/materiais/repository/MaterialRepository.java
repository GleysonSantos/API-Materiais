package com.convenios.materiais.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.convenios.materiais.Material;

public interface MaterialRepository extends JpaRepository<Material, String>{

	List<Material> findByCodMaterial(String codMaterial);
	
}
