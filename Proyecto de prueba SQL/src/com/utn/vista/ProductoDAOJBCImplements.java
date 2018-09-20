package com.utn.vista;

import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

public class ProductoDAOJBCImplements implements ProductoDAO {
	String url = "jdbc:mysql://localhost:3306/ejercicio base de datos ?useJDBCCompliantTimezoneShit=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password = "123";
	String query;
	Connection coneccion = null;
	@Override
	public void add(Producto productoAdd) {
		connection();
		try {
			query = "INSERT INTO `productos` (`precio`, `nombre`, `categoria`, `fechaDeVencimiento`) VALUES  (?,?,?,?)";
			PreparedStatement ps = coneccion.prepareStatement(query);
			ps.setInt(1, productoAdd.getPrecioI());
			ps.setString(2, productoAdd.getNombreProducto());
			ps.setInt(3, productoAdd.getCategoria());
			ps.setString(4, productoAdd.getFechaDeVencimiento());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}
	@Override
	public int update(Producto update) {
		int cantFilasUpdate = 0;
		query = "UPDATE `productos` SET `precio`= ? ,`nombre`= ? ,`categoria`= ?,`fechaDeVencimiento`= ? WHERE codigo = ?";
		connection();
		try {
			PreparedStatement ps = coneccion.prepareStatement(query);
			ps.setInt(1, update.getPrecioI());
			ps.setString(2, update.getNombreProducto());
			ps.setInt(3, update.getCategoria());
			ps.setString(4, update.getFechaDeVencimiento());
			ps.setInt(5, update.getIdProducto());
			cantFilasUpdate = ps.executeUpdate();
		} catch (SQLException e) {
		}
		closeConnection();
		return cantFilasUpdate;
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
	public String codificarPassword() {

		return null;

	}
}
