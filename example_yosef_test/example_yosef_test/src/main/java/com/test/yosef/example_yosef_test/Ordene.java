package com.test.yosef.example_yosef_test;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordenes database table.
 * 
 */
@Entity
@Table(name="ordenes")
@NamedQuery(name="Ordene.findAll", query="SELECT o FROM Ordene o")
public class Ordene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="orden_id")
	private int ordenId;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private BigDecimal total;

	//bi-directional many-to-one association to Sucursale
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="sucursal_id")
	private Sucursale sucursale;

	//bi-directional many-to-one association to Producto
	@JsonManagedReference
	@OneToMany(mappedBy="ordene" , cascade = CascadeType.ALL)
	private List<Producto> productos;

	public Ordene() {
	}

	public int getOrdenId() {
		return this.ordenId;
	}

	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Sucursale getSucursale() {
		return this.sucursale;
	}

	public void setSucursale(Sucursale sucursale) {
		this.sucursale = sucursale;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setOrdene(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setOrdene(null);

		return producto;
	}

}