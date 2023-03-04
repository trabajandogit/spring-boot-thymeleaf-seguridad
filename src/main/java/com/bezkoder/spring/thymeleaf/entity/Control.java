package com.bezkoder.spring.thymeleaf.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "control")
//@IdClass( com.bezkoder.spring.thymeleaf.entity.ControlPK.class )
public class Control {

	@EmbeddedId
	private ControlPK id;
	
	@Column(length = 70, nullable = false)
	private String titulo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
        @JoinColumn(name = "iddominio", referencedColumnName = "iddominio", insertable=false, updatable=false),
        @JoinColumn(name = "ordenobjetivo", referencedColumnName = "ordenobjetivo", insertable=false, updatable=false)})
	private Objetivo objetivo;
	
	public Control() {
	}

	public ControlPK getId() {
		return id;
	}

	public void setId(ControlPK id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	@Override
	public String toString() {
		return "Control [id=" + id + ", titulo=" + titulo + ", objetivo=" + objetivo + "]";
	}
	
}
