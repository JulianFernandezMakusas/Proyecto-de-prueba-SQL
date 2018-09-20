package com.utn.vista;
import javax.swing.JOptionPane;

import jdk.nashorn.internal.scripts.JO;
public class Main {
	public static void main(String[] args) {
		String precioString = null;
		int precioI = 0;
		String nombreProducto = null;
		String fechaDeVencimiento = null;
		int opcionSwitch = 0;
		int categoria = 0;
		String [] categoriaLista = {"   ","Limpieza","Comestible"};
		int idProducto;
		String [] opcionesSwitch = {"Añadir productos",
									"Ver Productos",
									"Modificar productos"}; 
		opcionSwitch = (int) JOptionPane.showOptionDialog(null, "Seleccione una opcion:", "Programa", opcionSwitch, JOptionPane.DEFAULT_OPTION, null, opcionesSwitch, JOptionPane.DEFAULT_OPTION);
		ProductoDAO productoDAO = ((ProductoDAOFactory) new ProductoDAOFactory()).createProductoDAO();
		productoDAO.codificarPassword();
		switch (opcionSwitch) {
		case 0://Cargar productos
			precioString = JOptionPane.showInputDialog("ingresa el precio de el producto");
			precioI= Integer.parseInt(precioString);
			nombreProducto = JOptionPane.showInputDialog("Ingresa el nombre de tu producto");
			categoria = JOptionPane.showOptionDialog(null, "Seleccione una opcion:", "Programa", categoria, JOptionPane.DEFAULT_OPTION, null, categoriaLista, 0);
			fechaDeVencimiento = JOptionPane.showInputDialog("Ingrese la fecha de vencimiento en el siguiente formato: Año-Mes-Dia");
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
			fechaDeVencimiento = JOptionPane.showInputDialog("Ingrese la fecha de vencimiento en el siguiente formato: Año-Mes-Dia");
			Producto productoUpdate = new Producto (precioI,nombreProducto,categoria,fechaDeVencimiento,idProducto);
			if (productoDAO.update(productoUpdate) == 1) {
				JOptionPane.showMessageDialog(null, "Modificado con exito", "Programa", JOptionPane.DEFAULT_OPTION);
			}else {
				JOptionPane.showMessageDialog(null, "No se modifico el producto", "Programa", JOptionPane.DEFAULT_OPTION);
			}
			break;
		case 3://Buscar archivos 
			break;		
		case 4://Eliminar productos
			break;
		case 5://
			break;
		}
		
	}

}
