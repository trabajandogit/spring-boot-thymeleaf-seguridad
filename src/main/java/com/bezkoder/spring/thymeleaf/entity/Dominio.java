package com.bezkoder.spring.thymeleaf.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dominio")
public class Dominio {

	@Id
	private Integer iddominio;

	@Column(length = 150, nullable = false)
	private String titulo;
	
	@OneToMany(mappedBy = "dominio", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Objetivo> objetivos = new ArrayList<>();
	
	public Dominio () {
	}
	
	public Dominio(String titulo, int iddominio) {
		this.iddominio = iddominio;
		this.titulo = titulo;
	}

	public Integer getIddominio() {
		return iddominio;
	}

	public void setIddominio(Integer iddominio) {
		this.iddominio = iddominio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	 @Override
	  public String toString() {
	    return "Dominio [id=" + iddominio + ", titulo=" + titulo+ "]";
	  }
}
