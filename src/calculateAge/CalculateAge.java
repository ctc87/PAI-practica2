package calculateAge;

import java.util.ArrayList;

/**
 * <h1>CalculateAge</h1>
 * CalculateAge es una clase para un ejercicio de una práctica 
 * de la asignatura: <br/>
 * <em>Programación de aplicaciones interactivas</em> <br/>
 * CalculateAge es una clase a la que se le pasan por parámetro
 * una fecha de nacimiento y la fecha actual y calcula la edad 
 * de la persona en años meses y días(asumiendo que cada mes 
 * tiene 31 días)<br/>
 * Lo hace a través de dos vectores en los que almacena la
 * fecha pasada por parámetro en formato:
 * <h4>
 * 	<font color="blue">
 * 		dd/mm/yyyy
 * 	</font>
 * </h4>
 * @author  Carlos Troyano Carmona
 * @version 1.2  
 * @since   2015-02-13
 * @see ArrayList 
 */
public class CalculateAge {
/**
 * Vector para almacenar la fecha actual en formato dd/mm/yyyy.	
 */
	private ArrayList<Integer> today = new ArrayList<Integer>();
	
/**
 * Vector para almacenar la fecha de nacimiento en formato dd/mm/yyyy.	
 */
	private ArrayList<Integer> birth = new ArrayList<Integer>();
	
/**
 * Constructor con fechas para CalculateAge en formato dd/mm/yyyy.<br/>
 * Inicializa el los vectores birth y today, parseando las cadenas
 * de entrada por parámetro, almacenando la fecha en las posiciones:<br>
 * 
 * -ArrayList[0] --> dd
 * -ArrayList[1] --> mm
 * -ArrayList[2] --> yyyy
 * 
 * @param firstDate Fecha actual.
 * @param secondDate Fecha de nacimiento.
 */

	public CalculateAge(String firstDate, String secondDate) {
		String aux = "";
		String aux2 = "";
		for(int i = 0; i < firstDate.length(); i++) {
			if(firstDate.charAt(i) != '/') {
				aux += firstDate.charAt(i);
			} else {
				today.add(Integer.parseInt(aux));
				aux = "";
			}
		}
		today.add(Integer.parseInt(aux));
                for(int i = 0; i < secondDate.length(); i++){
                        if(secondDate.charAt(i) != '/') {
                                aux2 += secondDate.charAt(i);
                        } else {
                                birth.add(Integer.parseInt(aux2));				
                                aux2 = "";
                        }
                }
                birth.add(Integer.parseInt(aux2));
	}
	
/**
  * @return *ArrayList<Integer> Retorna el atributo {@link CalculateAge#today} 
  */
	public ArrayList<Integer> getToday() {
		return today;
	}

 /**
  * @return *ArrayList<Integer> Retorna el atributo {@link CalculateAge#birth} 
  */
	public ArrayList<Integer> getBirth() {
		return birth;
 	}

/**
 * Método CalculateDifferences, Calcula las diferencias en días
 * meses y años(Asumiendo que todos los meses tienen 30 días). 
 * Entre las fechas almacenadas en los arrays pertenecientes
 * a la clase. Después lo imprime por pantalla.
 */

	public void CalculateDifferences() {
		Integer day;
		Integer month;
        Integer year;
		day = 31 - getBirth().get(0) + getToday().get(0);
		month = 12 - getBirth().get(1) + getToday().get(1);
		year = getToday().get(2) - getBirth().get(2);
		if(day > 0) {
			month--;
			year--;
		}
		year *= -1;
		year--;
		System.out.print("You have " + year + " years, " + month +  " months and ");
		System.out.print( day + " days. (assuming every month have 31 days) \n");
	}

	public static void main(String arg[]) {
		if(arg.length == 2) {
			CalculateAge cal = new CalculateAge(arg[1], arg[0]);
			cal.CalculateDifferences();
		} else {
			System.out.println("Error. The usage is $java CalculateAge dd/mm/yyyy dd/mm/yyyy");
		}	
	}

}
