package actividad1;

import java.util.Scanner;
import java.util.Hashtable;

public class mainApp {

	public static void main(String[] args) {
		/* Crea una aplicación que calcule la nota media de los alumnos pertenecientes
		 * al curso de programación. Una vez calculada la nota media se guardará esta información
		 * en un diccionario de datos que almacene la nota media de cada alumno.
		 * Todos estos datos se han de proporcionar por pantalla.*/
		
		int notas[][] = obtenerNotas();
		calcularNotaMedia (notas);
	}
	
	
	public static int [][] obtenerNotas(){
		Scanner sc = new Scanner (System.in);
		System.out.println("Introduce el número de alumnos:");
		int numAlumnos = sc.nextInt();
		
		System.out.println("Introduce el número de asignaturas:");
		int numAsignaturas = sc.nextInt();
		
		int notas[][] = new int [numAlumnos][numAsignaturas];
		
		//en este primer for recorremos el número de alumnos que hayamos introducido
		for (int i=0; i<notas.length; i++) {
			
			//en este segundo for recorremos el número de asignaturas del alumno
			for (int j=0; j<notas[i].length; j++) {
				System.out.println("Escribe la nota del alumno "+ (i+1)+" de la asignatura "+ (j+1)+":");
				notas[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		return notas;
	}
	
	
	public static void calcularNotaMedia(int notas[][]) {
		double media = 0;
		double resultado;
		
		Hashtable <Integer, Double> notaMedia = new Hashtable <Integer, Double>();
		for (int i=0; i<notas.length; i++) {
			for (int j=0; j<notas[i].length; j++) {
				media += notas[i][j];
			}
			resultado = media/(notas[i].length);
			notaMedia.put(i, resultado);
			
			//volvemos a ponerlo a 0 porque si no el 2o alumno sumará las notas del 1 alumno más las suyas
			media=0;
		}
		
		for (int i=0; i<notas.length; i++) {
			System.out.println("La nota media del alumno "+(i+1)+" es: "+notaMedia.get(i));
		}
		
	}

}

