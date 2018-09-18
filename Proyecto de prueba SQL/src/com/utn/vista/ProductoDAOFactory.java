package com.utn.vista;

public class ProductoDAOFactory {
	String precioString;
	int precioI;
	String nombreProducto;
	int categoria = 0;
	String [] categoriaLista = {"null","Limpieza","Comestible"};
	String fechaDeVencimiento;
	String query;
	int idProducto;
	public ProductoDAO createProductoDAO() {
		
		return new ProductoDAOJBCImplements();
	}
	
}
