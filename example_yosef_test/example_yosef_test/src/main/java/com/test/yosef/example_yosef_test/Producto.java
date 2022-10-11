package com.test.yosef.example_yosef_test;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.math.BigDecimal;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="producto_id")
	private int productoId;

	private String codigo;

	private String descripcion;

	private BigDecimal precio;

	//bi-directional many-to-one association to Ordene
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="orden_id")
	private Ordene ordene;

	public Producto() {
	}

	public int getProductoId() {
		return this.productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Ordene getOrdene() {
		return this.ordene;
	}

	public void setOrdene(Ordene ordene) {
		this.ordene = ordene;
	}

}