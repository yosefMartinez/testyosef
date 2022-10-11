package com.test.yosef.example_yosef_test;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the sucursales database table.
 * 
 */
@Entity
@Table(name="sucursales")
@NamedQuery(name="Sucursale.findAll", query="SELECT s FROM Sucursale s")
public class Sucursale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sucursal_id")
	private int sucursalId;

	private String nombre;



	//bi-directional many-to-one association to Ordene
	@JsonManagedReference
	@OneToMany(mappedBy="sucursale", cascade = CascadeType.ALL)
	private List<Ordene> ordenes;

	public Sucursale() {
	}

	public int getSucursalId() {
		return this.sucursalId;
	}

	public void setSucursalId(int sucursalId) {
		this.sucursalId = sucursalId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public List<Ordene> getOrdenes() {
		return this.ordenes;
	}

	public void setOrdenes(List<Ordene> ordenes) {
		this.ordenes = ordenes;
	}

	public Ordene addOrdene(Ordene ordene) {
		getOrdenes().add(ordene);
		ordene.setSucursale(this);

		return ordene;
	}

	public Ordene removeOrdene(Ordene ordene) {
		getOrdenes().remove(ordene);
		ordene.setSucursale(null);

		return ordene;
	}

}