package com.bezkoder.spring.thymeleaf.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class ObjetivoPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//@Id 
	@Column(name="iddominio", insertable=false, updatable=false)
	private Integer iddominio;
	
	//@Id
	private Integer ordenobjetivo;

	public ObjetivoPK() {
		
	}

	public Integer getIddominio() {
		return iddominio;
	}

	public void setIddominio(Integer iddominio) {
		this.iddominio = iddominio;
	}

	public Integer getOrdenobjetivo() {
		return ordenobjetivo;
	}

	public void setOrdenobjetivo(Integer ordenobjetivo) {
		this.ordenobjetivo = ordenobjetivo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(iddominio, ordenobjetivo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjetivoPK other = (ObjetivoPK) obj;
		return Objects.equals(iddominio, other.iddominio)
				&& Objects.equals(ordenobjetivo, other.ordenobjetivo);
	}

	@Override
	public String toString() {
		return "ObjetivoPK [iddominio=" + iddominio + ", ordenobjetivo=" + ordenobjetivo + "]";
	}

}
