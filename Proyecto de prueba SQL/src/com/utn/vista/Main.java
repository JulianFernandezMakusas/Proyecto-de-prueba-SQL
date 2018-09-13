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
		ProductoDAOJBCImplements metodos = new ProductoDAOJBCImplements();
		String precioString;
		int precioI;
		String nombreProducto;
		String fechaDeVencimiento;
		int opcionSwitch = 0;
		String [] opcionesSwitch = {"Cargar productos","Ver productos","Modificar productos"}; 
		opcionSwitch = JOptionPane.showOptionDialog(null, "Seleccione una opcion:", "Programa", opcionSwitch, JOptionPane.DEFAULT_OPTION, null, opcionesSwitch, JOptionPane.DEFAULT_OPTION);
		switch (opcionSwitch) {
		case 0://Cargar productos
			metodos.add();
			break;
		case 1://Ver productos
			metodos.consulta();
			break;
		case 2://Modificar productos
			metodos.update();
			break;
		}
		
		
	}

}
