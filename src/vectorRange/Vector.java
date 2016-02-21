package vectorRange;

import java.util.ArrayList;

/**
 * <h1>VectorRange</h1>
 * VectorRange es una clase para un ejercicio de una práctica 
 * de la asignatura: <br/>
 * <em>Programación de aplicaciones interactivas</em> <br/>
 * VectorRange es una clase carece de constructor y que solo
 * contiene el programa principal.<br/>
 * 
 * @author  Carlos Troyano Carmona
 * @version 1.2  
 * @since   2015-02-13
 * @see ReadVectorFile 
 */

public class Vector { 
/**
 * Función principal del programa que calcula la diferencia 
 * entre el número mayor y el número menor del array. Rellenado
 * a través de la clase ReadVectorFile, desde el fichero pasado
 * por parámetros.
 * @param args Vector de parámetros que contiene el 
 * nombre del fichero en la posición 0.
 * @see Double#NEGATIVE_INFINITY
 * @see Double#POSITIVE_INFINITY
 */
	public static void main(String[] args) {
		if(args.length > 0) {
			ReadVectorFile read = new ReadVectorFile(args[0]);
			ArrayList<Double> arrayReal = read.getArr();
			Double greatest = Double.NEGATIVE_INFINITY;
			Double smallest = Double.POSITIVE_INFINITY;
			for(int i = 0; i < arrayReal.size(); i++) {
				if(arrayReal.get(i).compareTo(greatest) > 0)
					greatest = arrayReal.get(i);
				if(arrayReal.get(i).compareTo(smallest) < 0)
					smallest = arrayReal.get(i);
			}
			System.out.println("Greatest: " + greatest + "  Smallest: " + smallest);
			System.out.println("Range: " + (greatest - smallest));
		} else
			System.out.println("Error");
	}
}
