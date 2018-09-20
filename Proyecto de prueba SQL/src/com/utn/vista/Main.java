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
		int categoria = 0;
		String [] categoriaLista = {"null","Limpieza","Comestible"};
		String query;
		int idProducto;
		String [] opcionesSwitch = {"A�adir productos","Ver Productos","Modificar productos"}; 
		opcionSwitch = JOptionPane.showOptionDialog(null, "Seleccione una opcion:", "Programa", opcionSwitch, JOptionPane.DEFAULT_OPTION, null, opcionesSwitch, JOptionPane.DEFAULT_OPTION);
		ProductoDAO productoDAO = ((ProductoDAOFactory) new ProductoDAOFactory()).createProductoDAO();
		productoDAO.codificarPassword();
		switch (opcionSwitch) {
		case 0://Cargar productos
			precioString = JOptionPane.showInputDialog("ingresa el precio de el producto");
			precioI= Integer.parseInt(precioString);
			nombreProducto = JOptionPane.showInputDialog("Ingresa el nombre de tu producto");
			categoria = JOptionPane.showOptionDialog(null, "Seleccione una opcion:", "Programa", categoria, JOptionPane.DEFAULT_OPTION, null, categoriaLista, 0);
			fechaDeVencimiento = JOptionPane.showInputDialog("Ingrese la fecha de vencimiento en el siguiente formato: A�o-Mes-Dia");
			Producto productoAdd= new Producto (precioI,nombreProducto,categoria,fechaDeVencimiento);
			productoDAO.add(productoAdd);
			break;
		case 1://Ver productos
			productoDAO.consulta();
			break;
		case 2://Modificar productos
			String idProductoString = JOptionPane.showInputDialog("Ingrese el ID del producto que va a editar:");
			idProducto = Integer.parseInt(idProductoString);
			precioString = JOptionPane.showInputDialog("Ingrese el precio que desea ponerle al producto:");
			precioI = Integer.parseInt(precioString);
			nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre que desea ingresar:");
			categoria = JOptionPane.showOptionDialog(null, "Seleccione una opcion:", "Programa", categoria, JOptionPane.DEFAULT_OPTION, null, categoriaLista, 0);
			fechaDeVencimiento = JOptionPane.showInputDialog("Ingrese la fecha de vencimiento en el siguiente formato: A�o-Mes-Dia");
			Producto productoUpdate = new Producto (precioI,nombreProducto,categoria,fechaDeVencimiento,idProducto);
			if (productoDAO.update(productoUpdate) == 1) {
				JOptionPane.showMessageDialog(null, "Modificado con exito", "Programa", JOptionPane.DEFAULT_OPTION);
			}
			break;
		}
		
		
	}

}
