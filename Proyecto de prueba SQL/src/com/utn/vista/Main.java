package com.utn.vista;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset.Concurrency;
public class Main {
	public static void main(String[] args) {
		String precioString = null;
		int precioI = 0;
		String nombreProducto = null;
		String fechaDeVencimiento = null;
		int opcionSwitch = 0;
		String [] opcionesSwitch = {"Añadir productos","Consulta","Modificar productos"}; 
		opcionSwitch = JOptionPane.showOptionDialog(null, "Seleccione una opcion:", "Programa", opcionSwitch, JOptionPane.DEFAULT_OPTION, null, opcionesSwitch, JOptionPane.DEFAULT_OPTION);
		String categoria = null;
		ProductoDAO productoDAO = ((ProductoDAOFactory) new ProductoDAOFactory()).createProductoDAO();
		switch (opcionSwitch) {
		case 0://Cargar productos
			productoDAO.add();
			break;
		case 1://Ver productos
			productoDAO.consulta();
			break;
		case 2://Modificar productos
			productoDAO.update();
			break;
		}
		
		
	}

}
