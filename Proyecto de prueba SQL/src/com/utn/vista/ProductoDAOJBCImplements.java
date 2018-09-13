package com.utn.vista;

import javax.swing.JOptionPane;

public class ProductoDAOJBCImplements implements ProductoDAO{
	String precioString;
	int precioI;
	String nombreProducto;
	String categoria;
	String fechaDeVencimiento;
	String query;
	@Override
	public void add() {
		precioString = JOptionPane.showInputDialog("ingresa el precio de el producto");
		precioI= Integer.parseInt(precioString);
		nombreProducto = JOptionPane.showInputDialog("Ingresa el nombre de tu producto");
		categoria = JOptionPane.showInputDialog("Ingrese la categoria");
		fechaDeVencimiento = JOptionPane.showInputDialog("Ingrese la fecha en el siguiente formato: Año-Mes-Dia");
		query = "INSERT INTO `productos` VALUES " + "([" + precioI + "],[" +  nombreProducto + "],[" + categoria + "],[" + fechaDeVencimiento + "])";
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void modificar() {
		
	}
	
}
