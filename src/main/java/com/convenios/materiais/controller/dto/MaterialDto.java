package com.convenios.materiais.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.convenios.materiais.Material;

public class MaterialDto {
	
	private String codMaterial;
	private String descricao;
	
	public MaterialDto(Material material) {
		this.codMaterial = material.getCodMaterial();
		this.descricao = material.getDescricao();
	}
	
	public String getCodMaterial() {
		return codMaterial;
	}
	public String getDescricao() {
		return descricao;
	}

	// CONVERSOR DE DTO PARA CLASSE NORMAL
	public static List<MaterialDto> converter(List<Material> material) {
		return material.stream().map(MaterialDto::new).collect(Collectors.toList());
	}
}
