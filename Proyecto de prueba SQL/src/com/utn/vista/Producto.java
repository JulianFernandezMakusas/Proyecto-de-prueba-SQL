package com.utn.vista;

public class Producto {
	private String precioString;
	private int precioI;
	private String nombreProducto;
	private String categoria;
	private String fechaDeVencimiento;
	public String getPrecioString() {
		return precioString;
	}
	public void setPrecioString(String precioString) {
		this.precioString = precioString;
	}
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
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
		return "Producto [precioString=" + precioString + ", precioI=" + precioI + ", nombreProducto=" + nombreProducto
				+ ", categoria=" + categoria + ", fechaDeVencimiento=" + fechaDeVencimiento + "]";
	}
	public Producto(String precioString, int precioI, String nombreProducto, String categoria,
			String fechaDeVencimiento) {
		super();
		this.precioString = precioString;
		this.precioI = precioI;
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		this.fechaDeVencimiento = fechaDeVencimiento;
	}
	
}
