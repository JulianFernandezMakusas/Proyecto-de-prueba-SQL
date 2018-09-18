package com.utn.vista;

public class Producto {
	private int precioI;
	private String nombreProducto;
	private int categoria;
	private String fechaDeVencimiento;
	public int getPrecioI() {
		return precioI;
	}
	public void setPrecioI(int precioI) {
		this.precioI = precioI;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}
	public void setFechaDeVencimiento(String fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}
	@Override
	public String toString() {
		return "Producto" + ", precioI=" + precioI + ", nombreProducto=" + nombreProducto
				+ ", categoria=" + categoria + ", fechaDeVencimiento=" + fechaDeVencimiento + "]";
	}
	public Producto(int precioI, String nombreProducto, int categoria,
			String fechaDeVencimiento) {
		super();
		this.precioI = precioI;
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		this.fechaDeVencimiento = fechaDeVencimiento;
	}
	
}
