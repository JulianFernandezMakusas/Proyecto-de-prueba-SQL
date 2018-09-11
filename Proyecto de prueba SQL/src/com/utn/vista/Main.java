package com.utn.vista;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.protocol.Resultset.Concurrency;
public class Main {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/ejercicio base de datos ?useJDBCCompliantTimezoneShit=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "";
		String query = "SELECT * FROM `productos` WHERE 1";
		try (Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				int precio = rs.getInt("precio");
				String nombre = rs.getString("nombre");
				int categoria = rs.getInt("categoria");
				Date fechaDeVencimiento = rs.getDate("fechaDeVencimiento");
				System.out.println("Codigo: " + codigo + "     Precio: " + precio + "     Nombre: " + nombre + "     Categoria: " + categoria + "     Fecha de vencimiento: " + fechaDeVencimiento);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

}
