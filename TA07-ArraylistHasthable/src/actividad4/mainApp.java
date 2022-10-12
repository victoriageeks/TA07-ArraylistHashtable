package actividad4;
import java.util.ArrayList;
import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) {
		/* Combina los métodos generados en las actividades 2 y 3 creando una misma aplicación que 
		 * gestione ventas y control de stock en una misma interfaz. 
		 * Utiliza para ello las estructuras de datos que creas conveniente.*/
		
		ArrayList<Integer> listaProductos = new ArrayList<Integer>();
		ArrayList<Double> precioProductos = new ArrayList<Double>();
		ArrayList<Integer> cantidadProductos = new ArrayList<Integer>();
	
		cantidadProductos.add(5);
		cantidadProductos.add(3);
		cantidadProductos.add(8);
		cantidadProductos.add(6);
		cantidadProductos.add(10);
		cantidadProductos.add(12);
		cantidadProductos.add(20);
		cantidadProductos.add(24);
		cantidadProductos.add(3);
		cantidadProductos.add(7);
		
		terminalInicial(listaProductos, precioProductos, cantidadProductos);

	}

	public static void terminalInicial(ArrayList<Integer> listaProductos, ArrayList<Double> precioProductos, ArrayList<Integer> cantidadProductos) {
		double IVA = 0;
		double total = 0;
		Scanner sc = new Scanner(System.in);
			System.out.println("-----------------------------");
			System.out.println("Bienvenido, ¿qué deseas hacer? \n1)Listar productos con su stock \n2)Añadir una cantidad de productos al carrito y comprar.");
			int eleccion = sc.nextInt();

			switch (eleccion) {
			case 1:
				listarStock(cantidadProductos);
				break;
			case 2:
				añadirProducto(listaProductos, precioProductos, cantidadProductos);
				if(IVAaplicado()) {
					IVA = 0.21;
				} else {
					IVA = 0.04;
				}
				total = precioTotal(IVA, listaProductos, precioProductos);
				articulosComprados(listaProductos);
				System.out.println("¿Cuánto dinero va a pagar?");
				double dinero = sc.nextDouble();
				cambio(dinero,total);
				break;
			}
		}
		
	
	public static void listarStock(ArrayList<Integer> cantidadProductos) {
		for(int i = 0; i < cantidadProductos.size(); i++) {
			System.out.println("ID-Producto: "+i+" || Stock: " + cantidadProductos.get(i));
		}
	}

	public static void añadirProducto(ArrayList<Integer> listaProductos, ArrayList<Double> precioProductos, ArrayList<Integer> cantidadProductos) {
		Scanner sc = new Scanner(System.in);

		System.out.println("¿Qué precio tiene el producto que quieres comprar?");
		double precio = sc.nextDouble();

		System.out.println("¿Cuál es su ID?");
		int id = sc.nextInt();
		
		System.out.println("¿Cuántos productos quieres comprar?");
		int num = sc.nextInt();
		
		if(num > cantidadProductos.get(id)) {
			System.out.println("No hay suficiente stock del producto que quieres comprar.");
		}
		else {
			precioProductos.add(precio);
			listaProductos.add(num);
			int total = cantidadProductos.get(id) - num;
			cantidadProductos.set(id,total);
		}
	}
 
	public static boolean IVAaplicado() {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Qué IVA está aplicado? ¿el 21% o 4%?");
		int IVA = sc.nextInt();
		if(IVA == 21) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static double precioTotal(double IVA, ArrayList<Integer> listaProductos, ArrayList<Double> precioProductos) {
		double resultado = 0;
		for(int i = 0; i < listaProductos.size(); i++) {
			resultado = resultado + (listaProductos.get(i) * precioProductos.get(i)); 
		}
		System.out.println("El precio total sin IVA es de: "+ resultado+"€.");
		
		
		ArrayList<Double> precioIVA = new ArrayList<Double>();
		
		for(int i = 0; i < listaProductos.size(); i++) {
			resultado = precioProductos.get(i)+(IVA*precioProductos.get(i));
			precioIVA.add(resultado);
		}
		
		resultado = 0;
		for(int i = 0; i < precioIVA.size(); i++) {
			resultado = resultado + (listaProductos.get(i) * precioIVA.get(i));
		}
		System.out.println("El precio total con IVA es de: "+ resultado+ "€.");
		
		return resultado;
	}
	
	public static void articulosComprados(ArrayList<Integer> listaProductos) {
		int resultado = 0;
		
		for(int i = 0; i < listaProductos.size(); i++) {
			resultado += listaProductos.get(i);
		}
		System.out.println("La cantidad total de productos que ha comprado es: "+resultado);
	}

	public static void cambio(double dinero,double cantidadTotal) {

		double total = cantidadTotal - dinero;
		System.out.println("El cambio a devolver es de: "+total+" euros.");
	}

}
