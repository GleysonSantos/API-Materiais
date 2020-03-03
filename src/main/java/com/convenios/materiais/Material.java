package com.convenios.materiais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Material {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String codMaterial;
	private String descricao;
	private String indAtivo;
	
	public String getCodMaterial() {
		return codMaterial;
	}
	public void setCodMaterial(String codMaterial) {
		this.codMaterial = codMaterial;
	}
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
	
	public Material() {
	}
		
	public Material(String descricao, String indAtivo) {
		this.descricao = descricao;
		this.indAtivo = indAtivo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codMaterial == null) ? 0 : codMaterial.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((indAtivo == null) ? 0 : indAtivo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (codMaterial == null) {
			if (other.codMaterial != null)
				return false;
		} else if (!codMaterial.equals(other.codMaterial))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (indAtivo == null) {
			if (other.indAtivo != null)
				return false;
		} else if (!indAtivo.equals(other.indAtivo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
