package rational;

/**
 * <h1>Rational</h1>
 * Rational es una ejercicio de una práctica de la asignatura: <br/>
 * <em>Programación de aplicaciones interactivas</em> <br/>
 * Rational es una clase que representa los números
 * irracionales con la representación:<br/>
 * <font color="blue">
 * &nbsp; n     <br/>
 *  -----   <br/>
 * &nbsp; d     <br/>
 * </font>
 * Dónde d y n son números enteros que representan el denominador
 * y el numerador.<br/>
 * Se implementan las cuatro operaciones básicas:
 * -Suma.
 * -Resta.
 * -Producto.
 * -Cociente.
 * 
 * @author  Carlos Troyano Carmona
 * @version 1.2  
 * @since   2015-02-13
 */
public class Rational {

/**
 * Atributo de la clase que representa el numerador.
 */
	private int numer;

/**
 * Atributo de la clase que representa el denominador.
 */
	private int denom;
	
/**
 * Función mcd, Calcula el máximo común divisor entre denominador 
 * y numerador y lo devuelve.
 * @return int Máximo común divisor.
 */
	private int mcd() {
		int u = Math.abs(this.numer);
		int v = Math.abs(this.denom);
		if(v == 0) {
			return u;
		 }
		 int r;
		 while(v != 0) {
			 r = u % v;
		     u = v;
		     v = r;
		 }
		     return u;
	}

/**
 * Función simplificar, simplifica el racional al mínimo posible, para ello 
 * utiliza la función privada mcd, para reducir al máximo común divisor.
 * @see rational.Rational#mcd
 * @return Rational Devuelve la instancia del objeto actual de la case Rational
 * ya simplificado.
 */
	private Rational simplificar() {
		int dividir = mcd();
	    this.numer /= dividir;
	    this.denom /= dividir;
	    return this;
	}
	
	
/**
 * Función countIntDigits. Retorna el número de dígitos de un dato
 * del primitivo tipo entero, pasado por parámetro.
 * Para ello cuenta el número de veces que puede dividirse entre 
 * diez hasta alcanzar el 0. Hay que denotar que esto es posible gracias
 * a que si el resultado de la división de un tipo primitivo int es menor
 * que 1 devuelve 0.
 * @param number Número del que queremos obtener la cantidad de dígitos. 
 * @return int Número de de dígitos.
 */
	private int countIntDigits(int number){
		int digits = 0;
		while(number != 0 ) {
			number /= 10;
			digits++;
		}
		return digits;
	} 
	
/**
 * Constante para el azul.
 */	 
	public static final String ANSI_BLUE = "\u001B[34m";

/**
 * Constante para el rojo.
 */
	public static final String ANSI_RED = "\u001B[31m";

/**
 * Constante para el verde.
 */
	public static final String ANSI_GREEN = "\u001B[32m";

/**
 * Constante para el color por defecto.
 */
	public static final String ANSI_RESET = "\u001B[0m";
	
/**
 * Constructor con números para Rational. Inicializa el denominador y numerador
 * con los parámetros pasados en dicho orden.
 * @param numerator Numerador del racional.
 * @param denominator Denominador del racional.
 */
	public Rational(int numerator, int denominator) {
		if (denominator == 0) {
		    throw new IllegalArgumentException("Argument 'denominator' is 0");
		} else {
			this.numer = numerator;
			this.denom = denominator;
		}
	}

/**
 * Método toString, convierte el objeto de la clase en una String. <br/>
 * Utiliza el método countIntDigits para darle el siguiente formato: <br/>
 * <font color="blue">
 * &nbsp; n     <br/>
 *  -----   <br/>
 * &nbsp; d     <br/>
 * </font>
 * Dónde d es el denominador y n el numerador. CountIntDigits sirve para
 * saber cuantas rayas "-" hay que añadir.
 * @see rational.Rational#countIntDigits 
 * @return String Objeto del tipo string que contiene la representación.
 */
	public String toString() {
		String message;
		if(this.numer != 0) {
			String line = "---";
			int digits = 0;
			digits = this.numer > this.denom ? countIntDigits(numer) : countIntDigits(denom);
			for(int i = 1; i < digits; i++){
				line += "-";
			}	
			message = "   " + numer + "\n  " + line + "\n" + "   " + denom + "\n";
		} else {
			message = "0\n";
		}
		return message;
	}
	
/**
 * Método adding, Suma dos racionales de la clase Rational. <br/>
 * @param secondAddend Racional explícito en la suma.
 * @return Rational Retorna un objeto de la clase racional con la suma de los dos 
 * el explícito y el implícito.
 */
    Rational adding(Rational secondAddend) {
    	int newDenominator = this.denom * secondAddend.denom;
		Rational result = new Rational(this.numer * newDenominator / this.denom + secondAddend.numer * newDenominator / secondAddend.denom, newDenominator);		
		return(result.simplificar());
    }
	
/**
 * Método subtract, Resta dos racionales de la clase Rational. <br/>
 * @param subtrahend Racional explícito en la resta.
 * @return Rational Retorna un objeto de la clase racional con la resta de los dos 
 * el explícito y el implícito.
 */
	Rational subtract(Rational subtrahend) {
		int newDenominator = this.denom * subtrahend.denom;
		Rational result = new Rational(this.numer * newDenominator / this.denom - subtrahend.numer * newDenominator / subtrahend.denom, newDenominator);
		return(result.simplificar());
	}
	
/**
 * Método multiply, multiplica dos racionales de la clase Rational. <br/>
 * @param multiplicand Racional explícito en la multiplicación.
 * @return Rational Retorna un objeto de la clase racional con la multiplicación 
 * de los dos el explícito y el implícito.
 */
	Rational multiply(Rational multiplicand) {
    	Rational result = new Rational(this.numer * multiplicand.numer, this.denom * multiplicand.denom);
        return(result.simplificar());
	}
	
/**
 * Método divide, divide dos racionales de la clase Rational. <br/>
 * @param divisor Racional explícito en la división.
 * @return Rational Retorna un objeto de la clase racional con la división de los dos 
 * el explícito y el implícito.
 */
	Rational divide(Rational divisor) {
		Rational result = new Rational(this.numer * divisor.denom, this.denom * divisor.numer);
		return(result.simplificar());
	}


	public static void main(String args[]) {
		Rational r1 = new Rational(1, 2);
		Rational r2 = new Rational(1, 2);
		boolean argsB;
		if(args.length > 0)
			argsB = ( args[0] == "--color" ) ? true : false;
		else 
			argsB = false;
			
		
		if(argsB)  {
			System.out.println(ANSI_BLUE + " Rational a:" + ANSI_RESET);
			System.out.println(ANSI_GREEN + r1.toString() + ANSI_RESET);
			System.out.println(ANSI_BLUE + " Rational b:" + ANSI_RESET);
	        System.out.println(ANSI_GREEN + r2.toString() + ANSI_RESET);
			Rational r3 = r1.adding(r2);
			System.out.println(ANSI_RED + " a + b:" + ANSI_RESET);
	        System.out.println(ANSI_GREEN + r3.toString() + ANSI_RESET);
			Rational r4 = r3.subtract(r2);
			System.out.println(ANSI_RED + " a - b:" + ANSI_RESET);
		    System.out.println(ANSI_GREEN + r4.toString() + ANSI_RESET);
			Rational r5 = r1.multiply(r2);
			System.out.println(ANSI_RED + " a * b:" + ANSI_RESET);
		    System.out.println(ANSI_GREEN + r5.toString() + ANSI_RESET);
			Rational r6 = r1.divide(r2);
			System.out.println(ANSI_RED + " a / b:" + ANSI_RESET);
	        System.out.println(ANSI_GREEN + r6.toString() + ANSI_RESET);
		} else {
			System.out.println(" Rational a:");
			System.out.println(r1.toString());
			System.out.println(" Rational b:");
	        System.out.println(r2.toString());
			Rational r3 = r1.adding(r2);
			System.out.println(" a + b:");
	        System.out.println(r3.toString());
			Rational r4 = r3.subtract(r2);
			System.out.println(" a - b:");
		    System.out.println(r4.toString());
			Rational r5 = r1.multiply(r2);
			System.out.println(" a * b:");
		    System.out.println(r5.toString());
			Rational r6 = r1.divide(r2);
			System.out.println(" a / b:");
	        System.out.println(r6.toString());		
		}
	}
	
};
