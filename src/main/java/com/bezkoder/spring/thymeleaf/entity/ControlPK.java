package com.bezkoder.spring.thymeleaf.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ControlPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="iddominio", insertable=false, updatable=false)
	private Integer iddominio;

	@Column(name="ordenobjetivo", insertable=false, updatable=false)
	private Integer ordenobjetivo;
	
	private Integer control;
	
	public ControlPK () {
		
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

	public Integer getControl() {
		return control;
	}

	public void setControl(Integer control) {
		this.control = control;
	}

	@Override
	public int hashCode() {
		return Objects.hash(control, iddominio, ordenobjetivo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControlPK other = (ControlPK) obj;
		return Objects.equals(control, other.control) && Objects.equals(iddominio, other.iddominio)
				&& Objects.equals(ordenobjetivo, other.ordenobjetivo);
	}

	@Override
	public String toString() {
		return "ControlPK [iddominio=" + iddominio + ", ordenobjetivo=" + ordenobjetivo + ", control=" + control + "]";
	}

}
