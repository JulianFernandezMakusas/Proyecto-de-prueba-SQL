package com.utn.vista;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Locale;

import javax.swing.JOptionPane;

import jdk.nashorn.internal.scripts.JO;

public class ProductoDAOJBCImplements implements ProductoDAO{
	String url = "jdbc:mysql://localhost:3306/ejercicio base de datos ?useJDBCCompliantTimezoneShit=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password = "123";
	String precioString;
	int precioI;
	String nombreProducto;
	int categoria = 0;
	String [] categoriaLista = {"null","Limpieza","Comestible"};
	String fechaDeVencimiento;
	String query;
	int idProducto;
	Connection coneccion = null;
	@Override
	public void add(Producto producto) {
		connection();
		try {
			query = "INSERT INTO `productos` (`precio`, `nombre`, `categoria`, `fechaDeVencimiento`) VALUES  (?,?,?,?)";
			PreparedStatement ps = coneccion.prepareStatement(query);
			ps.setInt(1, producto.getPrecioI());
			ps.setString(2, producto.getNombreProducto());
			ps.setInt(3, producto.getCategoria());
			ps.setString(4, producto.getFechaDeVencimiento());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}
	
	@Override
	public void update() {
		String [] listaOpciones = {"Precio","Nombre","Categoria","Fecha de vencimiento"};
		String idProductoString = JOptionPane.showInputDialog("Ingrese el ID del producto que va a editar:");
		int idProducto = Integer.parseInt(idProductoString);
		int opciones = 0;
		opciones = JOptionPane.showOptionDialog(null, "Seleccione el dato que desea editar:", "Programa", opciones, JOptionPane.DEFAULT_OPTION, null, listaOpciones, 0);
		switch (opciones) {
		case 0://Precio
			precioString = JOptionPane.showInputDialog("Ingrese el precio que desea ponerle al producto:");
			precioI = Integer.parseInt(precioString);
			query = "UPDATE `productos` SET `precio` = ? WHERE codigo = ?";
			connection();
			try {
				PreparedStatement ps = coneccion.prepareStatement(query);
				ps.setInt(1, precioI);
				ps.setInt(2, idProducto);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection();
			break;
		case 1://Nombre
			nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre que le desea poner al producto:");
			query = "UPDATE `productos` SET `nombre` = ? WHERE codigo = ?";
			connection();
			try {
				PreparedStatement ps = coneccion.prepareStatement(query);
				ps.setString(1, nombreProducto);
				ps.setInt(2, idProducto);
				ps.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection();
			break;
		case 2://Categoria
			categoria = JOptionPane.showOptionDialog(null, "Seleccione una opcion:", "Programa", categoria, JOptionPane.DEFAULT_OPTION, null, categoriaLista, 0);
			query = "UPDATE `productos` SET `categoria`= ? WHERE codigo = ?";
			connection();
			try {
				PreparedStatement ps = coneccion.prepareStatement(query);
				ps.setInt(1, categoria);
				ps.setInt(2, idProducto);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection();
			break;
		case 3://Fecha de vencimiento
			fechaDeVencimiento = JOptionPane.showInputDialog("Ingrese la fecha de vencimiento en el siguiente formato: Año-Mes-Dia");
			query = "UPDATE `productos` SET `fechaDeVencimiento`= ? WHERE codigo = ?";
			connection();
			try {
				PreparedStatement ps = coneccion.prepareStatement(query);
				ps.setString(1, fechaDeVencimiento);
				ps.setInt(2, idProducto);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection();
			break;
		}
	}

	@Override
	public void consulta() {
		query = "SELECT * FROM `productos` ";
		connection();
		try {
			PreparedStatement ps = coneccion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				JOptionPane.showMessageDialog(null, rs.getString("nombre"));
				JOptionPane.showMessageDialog(null, rs.getInt("codigo"));
				JOptionPane.showMessageDialog(null, rs.getInt("precio"));				
				JOptionPane.showMessageDialog(null, rs.getString("categoria"));
				JOptionPane.showMessageDialog(null, rs.getString("fechaDeVencimiento"));
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
		public String getCredentials() {
			return "UPC ".concat(Base64.getEncoder().encodeToString(username.concat(":").concat(password).getBytes(StandardCharsets.UTF_8)));
		}



}
