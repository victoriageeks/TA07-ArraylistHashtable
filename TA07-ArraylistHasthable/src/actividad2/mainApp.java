package actividad2;

import java.util.ArrayList;
import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) {
		/* Crea una aplicación que gestione el flujo de ventas de una caja de supermercado.
		 * El programa guardará las cantidades del carrito de compra dentro de una lista.
		 * Mostrará por pantalla la siguiente información: 
		 * 
		 *  - IVA aplicado (21% o 4%)
		 *  - precio total bruto y precio + IVA
		 *  - número de artículos comprados
		 *  - cantidad pagada
		 *  - cambio a devolver al cliente.*/
		
		Scanner sc = new Scanner(System.in);
		
		//Arraylist Productos
		ArrayList<Double> productos = new ArrayList<>();
		
		
		//Cantidad comprada de productos
		System.out.println("Introduce la cantidad de galletas que quieras comprar:");
		Integer galletas = sc.nextInt();
		
		System.out.println("Introduce la cantidad de patatas que quieras comprar:");
		Integer patatas = sc.nextInt();
		
		System.out.println("Introduce la cantidad de palomitas que quieras comprar:");
		Integer palomitas = sc.nextInt();
		
		System.out.println("Introduce la cantidad de pañuelos que quieras comprar:");
		Integer panuelos = sc.nextInt();
		
		System.out.println("Introduce la cantidad de toallitas que quieras comprar:");
		Integer toallitas = sc.nextInt();
		
		int numProductos = galletas + patatas + palomitas + panuelos + toallitas;
		System.out.println("\nCantidad de productos comprada: " + numProductos+".\n");
		
		//calcular precio bruto
		double galletas_PB = galletas*0.75;
		double patatas_PB = patatas*1.89;
		double palomitas_PB = palomitas*2.25;
		double panuelos_PB = panuelos*1.50;
		double toallitas_PB = toallitas*2.30;
		System.out.println("--- PRECIO BRUTO PRODUCTOS ---");
		System.out.println("Galletas : "+galletas_PB+" euros.\nPatatas: "+patatas_PB+" euros.\nPalomitas: "+palomitas_PB+" euros.\nPañuelos: "+panuelos_PB+" euros.\nToallitas: "+toallitas_PB+" euros.\n");
		
		//añadimos al arraylist los productos
		productos.add(galletas_PB);
		productos.add(patatas_PB);
		productos.add(palomitas_PB);
		productos.add(panuelos_PB);
		productos.add(toallitas_PB);
		
		//calcular el precio con iva
		double galletas_IVA = galletas_PB * 1.04;
		double patatas_IVA = patatas_PB * 1.04;
		double palomitas_IVA = palomitas_PB * 1.04;
		double panuelos_IVA = panuelos_PB * 1.21;
		double toallitas_IVA = toallitas_PB * 1.21;
		System.out.println("--- PRECIO PRODUCTOS + IVA ---");
		System.out.println("Galletas : "+galletas_IVA+" euros.\nPatatas: "+patatas_IVA+" euros.\nPalomitas: "+palomitas_IVA+" euros.\nPañuelos: "+panuelos_IVA+" euros.\nToallitas: "+toallitas_IVA+" euros.\n");
		
		
		//Calcular precio total a pagar
		double precioTotal = galletas_IVA + patatas_IVA + palomitas_IVA + panuelos_IVA + toallitas_IVA;
		System.out.println("---PARTE FINAL DE LA COMPRA---");
		System.out.println("Debe pagar: "+precioTotal+" euros.");
		
		double totalPagado = 0;
		double pagar = 0;
		double faltaPagar = 0;
		double devolver = 0;
		
		//Momento de pagar
		while(totalPagado<precioTotal) {
			System.out.println("Indique la cantidad de dinero que va a pagar:");
			pagar = sc.nextDouble();
			totalPagado+=pagar;
			
			if(totalPagado>precioTotal) {
				devolver = totalPagado - precioTotal;
				System.out.println("El cambio a devolver es: " + devolver + " euros.");
			} else {
				faltaPagar = precioTotal - totalPagado;
				System.out.println("Falta por pagar: " + faltaPagar + " euros.");
			}
		}
		
		
		System.out.println("Arraylist de la lista de productos: "+productos.toString());
	
	}

}
