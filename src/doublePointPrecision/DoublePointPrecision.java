package doublePointPrecision;
import java.lang.Math;
import java.util.Scanner;

/**
 * <h1>DoublePointPrecision</h1>
 * DoublePointPrecision es una clase para un ejercicio de una práctica 
 * de la asignatura: <br/>
 * <em>Programación de aplicaciones interactivas</em> <br/>
 * DoublePointPrecision es una clase que contiene dos 
 * números reales y un atributo que dicen si son iguales o no 
 * a partir de una constante de precisión.
 * 
 * @author  Carlos Troyano Carmona
 * @version 1.2  
 * @since   2015-02-13
 * @see Math#abs 
 * @see Math#max
 */
public class DoublePointPrecision {
	
/**
 * Constante de la clase que representa la precisión con la que vamos a 
 * comparar los dos números reales.
 */
   public final double PRECISION = 0.0000000000000000000001;
   
/**
 * Numero real para la comparación.
 */
   private double num1;
   
/**
 * Numero real para la comparación.
 */
   private double num2;
   
/**
 * Atributo que contiene verdadero si ambos números
 * son iguales medidos con la precisión.
 * @see DoublePointPrecision#PRECISION
 */
   private boolean equal;
   
/**
 * Constructor,  construye la instancia con dos 
 * números y con el método, itsEqual, que rellena
 * el atributo equal.
 * @see DoublePointPrecision#itsEqual
 * @param numA Número real para la comparación.
 * @param numB Número real para la comparación.
 */
   public DoublePointPrecision(double numA, double numB) {
     setNum1(numA);
     setNum2(numB);
     itsEqual();		
   }	
 
/**
 * @return boolean Atributo {@link DoublePointPrecision#equal} 
 */
   private boolean getEqual() {
	   return equal;
   }
   
/**
 * @param equ Establece el atributo {@link DoublePointPrecision#equal} 
 */
  private void setEqual(boolean equ) {
    equal = equ;
  }	
  
/**
 * @param a Establece el atributo {@link DoublePointPrecision#num1} 
 */
  private void setNum1(double a) {
  	num1 = a;
  }	
  
/**
 * @param a Establece el atributo {@link DoublePointPrecision#num2} 
 */
  private void setNum2(double a) {
    num2 = a;
  }
/**
 * Función que rellena el parámetro {@link DoublePointPrecision#equal} 
 * con verdadero o falso en función de la precisión. En definitiva es
 * donde se hace la comparación de ambos números.
 * @see Math#abs 
 * @see Math#max
 * @see DoublePointPrecision#PRECISION 
 */
  private void itsEqual() {
    final double diff = Math.abs(num1 - num2);
    setEqual(diff  <= Math.max(num1,num2) * PRECISION); 		
  }
  
/**
 * Función main que contiene la ejecución y prueba de clase
 * Con el parámetro -i se puede hacer interactivamente. Si no
 * lo realizara mediante una prueba ya definida.
 */
  public static void main(String arg[]) {
    double firstDoubleNumber, secondDoubleNumber;
    DoublePointPrecision prec;
    System.out.print("This program compare two double numbers to see if they are equal:\n");
    if(arg.length > 0) {
      if(arg[0].compareTo("-i") == 0) {
        Scanner sc = new Scanner(System.in);
      String opt = "";
      while(opt.compareTo("q") != 0) {
        try {
          System.out.print("\nWrite the first double number and press enter:\n");
          firstDoubleNumber = Double.parseDouble(sc.nextLine());
          System.out.print("\nWrite the second double number and press enter:\n");
          secondDoubleNumber = Double.parseDouble(sc.nextLine());
          prec = new DoublePointPrecision(firstDoubleNumber, secondDoubleNumber);
          String afirmation = prec.getEqual() ?"true" :"false";
          System.out.print(firstDoubleNumber + " and ");
          System.out.print(secondDoubleNumber + " are equals : " + afirmation);
          System.out.print("\nPress q to exit or other key to continue:\n");
          opt = sc.nextLine();
          } catch (Exception e) {
        	e.toString();
            e.printStackTrace();
          }
        }
      sc.close();
      }
    } else {
      firstDoubleNumber = 10.000000000000002;
      secondDoubleNumber = 10.00000000000001;
      prec = new DoublePointPrecision(firstDoubleNumber, secondDoubleNumber);
      String afirmation = prec.getEqual() ? "true" : "false";
      System.out.print(firstDoubleNumber + " and ");
      System.out.print(secondDoubleNumber + " are equals : " + afirmation + "\n");
      firstDoubleNumber = 10.000000000000000;
      secondDoubleNumber = 10.0;
      prec = new DoublePointPrecision(firstDoubleNumber, secondDoubleNumber);
      afirmation = prec.getEqual() ? "true" : "false";
      System.out.print(firstDoubleNumber + " and ");
      System.out.print(secondDoubleNumber);
      System.out.print(" are equals : " + afirmation + "\n");			
    }
  }
}

