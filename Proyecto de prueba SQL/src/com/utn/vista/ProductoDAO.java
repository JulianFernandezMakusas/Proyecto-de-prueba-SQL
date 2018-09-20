package com.utn.vista;

public interface ProductoDAO {
	public void add (Producto producto);
	public int update(Producto producto);
	public void consulta();
	public void connection();
	public void closeConnection();
	public String codificarPassword();
	}
