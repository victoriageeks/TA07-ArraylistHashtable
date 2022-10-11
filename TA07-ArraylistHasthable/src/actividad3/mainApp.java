package actividad3;

import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class mainApp {

	public static void main(String[] args) {
		/* Crea una base de datos de 10 artículos para controlar el stock de productos
		 * de una tienda por medio de un diccionario de datos (articulo:precio).
		 * El usuario podrá añadir, por medio de interfaz visual, artículos
		 * nuevos y cantidades de estos. El usuario podrá consultar información
		 * almacenada en el diccionario referente a un artículo concreto
		 * e incluso listar toda la información en la terminal del programa.*/

		//Base de datos con 10 artículos
		Hashtable<String,Double> productos = new Hashtable<String,Double>();
		
		productos.put("funko", 14.75);
		productos.put("lego", 12.95);
		productos.put("peluche", 29.99);
		productos.put("mando", 59.95);
		productos.put("llavero", 10.99);
		productos.put("teclado", 65.00);
		productos.put("videojuego", 59.95);
		productos.put("pelicula", 17.50);
		productos.put("cromos", 1.99);
		productos.put("raton", 20.00);
		
		String eleccion_U=JOptionPane.showInputDialog("Bienvendid@ a la tienda de videojuegos, ¿qué quiere realizar?\n1)Añadir productos.\n2)Modificar productos.\n3)Listar toda la información)");
		int eleccion = Integer.parseInt(eleccion_U);
		
		switch(eleccion) {
		case 1:
			int i=0;
			String nombre = JOptionPane.showInputDialog("Escribe el nombre del producto.");
			String precio_U = JOptionPane.showInputDialog("Escribe su precio.");
			double precio = Double.parseDouble(precio_U);
			String cantidad_U = JOptionPane.showInputDialog("Escribe la cantidad de productor para añadir.");
			int cantidad = Integer.parseInt(cantidad_U);
			
				while(i<cantidad) {
					productos.put(nombre, precio);
					System.out.println("Producto añadido a la tienda!");
				}
		break;
		case 2:
			String modificar_U = JOptionPane.showInputDialog("Indica el nombre del producto a modificar:").toLowerCase();
			if (productos.containsKey(modificar_U)) {
				precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce precio"));
				productos.replace(modificar_U, precio);
				System.out.println("Producto modificado correctamente!");
			}else {
				JOptionPane.showMessageDialog(null, "No ha introducido un nombre de producto existente.");
			}
		break;
		case 3:
			Enumeration<String> productos_k = productos.keys();
			Enumeration<Double> productos_e = productos.elements();
			
			while(productos_e.hasMoreElements()) {
				System.out.println("Producto: "+ productos_k.nextElement()+ " // Precio: "+ productos_e.nextElement());
				System.out.println("");
			}
		break;
		}
	}

}
