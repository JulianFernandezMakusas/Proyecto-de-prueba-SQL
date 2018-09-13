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
	static String url = "jdbc:mysql://localhost:3306/ejercicio base de datos ?useJDBCCompliantTimezoneShit=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String username = "root";
	static String password = "";
	static String query;
	public static void main(String[] args) {
		
		String precioString;
		int precioI;
		String nombreProducto;
		String categoria;
		String fechaDeVencimiento;
		
		int opcionSwitch = 0;
		String [] opcionesSwitch = {"Cargar productos","Ver productos","Modificar productos"}; 
		opcionSwitch = JOptionPane.showOptionDialog(null, "Seleccione una opcion:", "Programa", opcionSwitch, JOptionPane.DEFAULT_OPTION, null, opcionesSwitch, JOptionPane.DEFAULT_OPTION);
		switch (opcionSwitch) {
		case 0://Cargar productos
			
			try (Connection con = DriverManager.getConnection(url, username, password)){
				
			} catch (SQLException e) {
				System.out.println(e);
			}
			break;
		case 1://Ver productos
			query = "SELECT * FROM `productos` WHERE 1";
			break;
		case 2://Modificar productos
			query = "";
			break;
		}
		
		
	}

}
