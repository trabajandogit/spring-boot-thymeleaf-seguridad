package com.bezkoder.spring.thymeleaf.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "objetivo")
//@IdClass( ObjetivoPK.class )
public class Objetivo {

	@EmbeddedId
    private ObjetivoPK id;	

	@Column(length = 70, nullable = false)
	private String titulo;

    @ManyToOne(optional = false)
    @JoinColumns({
        @JoinColumn(name = "iddominio", referencedColumnName = "iddominio", insertable=false, updatable=false)})
	private Dominio dominio;

	@OneToMany(mappedBy = "objetivo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Control> controles = new ArrayList<>();

	
	public Objetivo () {
	}
	
	public ObjetivoPK getId() {
		return id;
	}

	public void setId(ObjetivoPK objetivopk) {
		id.setIddominio(objetivopk.getIddominio());
		id.setOrdenobjetivo(objetivopk.getOrdenobjetivo());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Dominio getDominio() {
		return dominio;
	}

	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
	}

	@Override
	public String toString() {
		return "Objetivo [iddominio=" + id.getIddominio() + ", ordenobjetivo=" + id.getOrdenobjetivo() + ", titulo=" + titulo
				+ ", dominio=" + dominio + "]";
	}
	

}