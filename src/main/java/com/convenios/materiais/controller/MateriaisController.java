package com.convenios.materiais.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.convenios.materiais.Material;
import com.convenios.materiais.controller.dto.DetalhesDoMaterialDto;
import com.convenios.materiais.controller.dto.MaterialDto;
import com.convenios.materiais.controller.form.AtualizacaoMaterialForm;
import com.convenios.materiais.controller.form.MaterialForm;
import com.convenios.materiais.repository.MaterialRepository;

@RestController
public class MateriaisController {
	
	@Autowired
	private MaterialRepository materialRepository;
	
	@GetMapping("/materiais")
	public List<MaterialDto> listaDeMateriais(String codMaterial) {
		if (codMaterial == null) {
			List<Material> materiais = materialRepository.findAll();
			return MaterialDto.converter(materiais);
		}else {
			List<Material> materiais = materialRepository.findByCodMaterial(codMaterial);
			return MaterialDto.converter(materiais);
		}		
	}
	
	@PostMapping("/materiais")
	@Transactional
	public ResponseEntity<MaterialDto> cadastrar(@RequestBody @Valid MaterialForm materialForm, UriComponentsBuilder uriBuilder) {
		Material material = materialForm.converter();
		materialRepository.save(material);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(material.getCodMaterial()).toUri();
		return ResponseEntity.created(uri).body(new MaterialDto(material));
	}
	
	@GetMapping("/materiais/{id}")
	public DetalhesDoMaterialDto detalharMaterial(@PathVariable("id") String codMaterial) {
		Material material = materialRepository.getOne(codMaterial);
		return new DetalhesDoMaterialDto(material);
	}
	
	@PutMapping("/materiais/{id}")
	@Transactional
	public ResponseEntity<MaterialDto> atualizar(@PathVariable("id") String codMaterial, @RequestBody @Valid AtualizacaoMaterialForm atualizacaoMaterialForm) {
		Material material = atualizacaoMaterialForm.atualizar(codMaterial, materialRepository);
		return ResponseEntity.ok(new MaterialDto(material));
	}
	
	@DeleteMapping("/materiais/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable("id") String codMaterial){
		materialRepository.deleteById(codMaterial);
		return ResponseEntity.ok().build();
	}	
}
