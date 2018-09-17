package com.utn.vista;

public class ProductoDAOFactory {
	public ProductoDAO createProductoDAO () {
		return new ProductoDAOJBCImplements();
	}

}
