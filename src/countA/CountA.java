package countA;

import java.util.Scanner;
/**
 * <h1>CountA</h1>
 * CountA es una clase para un ejercicio de una práctica 
 * de la asignatura: <br/>
 * <em>Programación de aplicaciones interactivas</em> <br/>
 * CountA es una clase vacía que solo contiene un método
 * main que pide por teclado una cadena y cuenta el número
 * de a y A que tiene, después lo imprime por pantalla.<br/>
 * 
 * @author  Carlos Troyano Carmona
 * @version 1.2  
 * @since   2015-02-13
 * @see Scanner 
 */
class CountA {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int numberA = 0;
        	System.out.print("Write a sentence to read the number of a and A:\n" );
       	 	String sentence = sc.nextLine(); 
		for(int i = 0; i < sentence.length(); i++) {
			if((sentence.charAt(i) == 'a') || (sentence.charAt(i) == 'A'))
				numberA++;
		}
        	System.out.print("The number of characters A or a is: " + numberA + "\n");
        sc.close();
	}
	
} 
