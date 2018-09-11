package com.utn.vista;

public interface ProductoDAO {
	public void add ();
	public void update();
	public void delete();
	public Producto findByName();
	public Producto getAllProducto();
	public void getConnection();
}
