package com.convenios.materiais.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.convenios.materiais.Material;
import com.convenios.materiais.repository.MaterialRepository;

public class AtualizacaoMaterialForm {
	
	@NotNull @NotEmpty
	private String descricao;
	
	@NotNull @NotEmpty @Length(max = 1, min = 1)
	private String indAtivo;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIndAtivo() {
		return indAtivo;
	}

	public void setIndAtivo(String indAtivo) {
		this.indAtivo = indAtivo;
	}

	public Material atualizar(String codMaterial, MaterialRepository materialRepository) {
		Material material = materialRepository.getOne(codMaterial);
		
		material.setDescricao(this.descricao);
		material.setIndAtivo(this.indAtivo);
		
		return material;
	}

	
}
