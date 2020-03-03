package com.convenios.materiais.controller.dto;

import com.convenios.materiais.Material;

public class DetalhesDoMaterialDto {
	
	private String codMaterial;
	private String descricao;
	private String indAtivo;
	
	public DetalhesDoMaterialDto(Material material) {
		this.codMaterial = material.getCodMaterial();
		this.descricao = material.getDescricao();
		this.indAtivo = material.getIndAtivo();
	}

	public String getCodMaterial() {
		return codMaterial;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getIndAtivo() {
		return indAtivo;
	}
}
