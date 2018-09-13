package com.utn.vista;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ProductoDAOJBCImplements implements ProductoDAO{
	private static final Object[] options = null;
	String url = "jdbc:mysql://localhost:3306/ejercicio base de datos ?useJDBCCompliantTimezoneShit=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password = "";
	String precioString;
	int precioI;
	String nombreProducto;
	int categoria = 0;
	String [] categoriaLista = {"null","Limpieza","Comestible"};
	String fechaDeVencimiento;
	String query;
	Connection coneccion = null;
	@Override
	public void add() {
		precioString = JOptionPane.showInputDialog("ingresa el precio de el producto");
		precioI= Integer.parseInt(precioString);
		nombreProducto = JOptionPane.showInputDialog("Ingresa el nombre de tu producto");
		categoria = JOptionPane.showOptionDialog(null, "Seleccione una opcion:", "Programa", categoria, JOptionPane.DEFAULT_OPTION, null, categoriaLista, 0);
		fechaDeVencimiento = JOptionPane.showInputDialog("Ingrese la fecha en el siguiente formato: Año-Mes-Dia");
		query = "INSERT INTO `productos` (`precio`, `nombre`, `categoria`, `fechaDeVencimiento`) VALUES  (?,?,?,?)";
		connection();
		try {
			PreparedStatement ps = coneccion.prepareStatement(query);
			ps.setInt(1, precioI);
			ps.setString(2, nombreProducto);
			ps.setInt(3, categoria);
			ps.setString(4, fechaDeVencimiento);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}
	
	@Override
	public void update() {
		
		query = "";
	}

	@Override
	public void consulta() {
		query = JOptionPane.showInputDialog("Ingrese la consulta: ");
		connection();
		try {
			PreparedStatement ps = coneccion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (query.equals("SELECT * FROM `productos` WHERE 1")) {
				while (rs.next()) {
					int codigo = rs.getInt("codigo");
					int precio = rs.getInt("precio");
					String nombre = rs.getString("nombre");
					int categoria = rs.getInt("categoria");
					Date fechaDeVencimiento = rs.getDate("fechaDeVencimiento");
					JOptionPane.showMessageDialog(null, "Codigo: " + codigo + "     Precio: " + precio + "     Nombre: " + nombre + "     Categoria: " + categoria + "     Fecha de vencimiento: " + fechaDeVencimiento, "Prograna", JOptionPane.DEFAULT_OPTION);
				}				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void connection() {
		try {
			coneccion = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeConnection() {
		try {
			coneccion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
