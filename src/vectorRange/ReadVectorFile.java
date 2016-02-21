package vectorRange;

import java.util.*;
import java.io.*;

/**
 * <h1>ReadVectorFile</h1>
 * ReadVectorFile es una clase para un ejercicio de una práctica 
 * de la asignatura: <br/>
 * <em>Programación de aplicaciones interactivas</em> <br/>
 * ReadVectorFile es una clase que lee un fichero pasado por 
 * parámetro al constructor y con el construye un vector de 
 * números reales.<br/>
 * 
 * Contiene un método que devuelve dicho vector.
 * 
 * @author  Carlos Troyano Carmona
 * @version 1.2  
 * @since   2015-02-13
 * @see ArrayList 
 * @see File
 * @see FileReader
 * @see BufferedReader
 * @see Exception
 */

public class ReadVectorFile {

/**
 * Array de reales miembro de la clase.
 */
	private ArrayList<Double> arr = new ArrayList<Double>();

/**
 * @return ArrayList<Double> retorna un array de números
 * reales leído desde el fichero con el constructor.
 */
	public ArrayList<Double> getArr() {
		return arr;
	}
	
/**
 * Constructor con cadena para ReadVectorFile, lee el archivo
 * pasado por parámetro línea a línea e inserta un real por cada
 * uno descrito en las líneas del archivo. Se controlan los 
 * errores mediante la clase Exception.
 * @param str ruta al fichero.
 * @see File
 * @see FileReader
 * @see BufferedReader
 * @see Exception
 */
	public ReadVectorFile(String str) {
		String line;
		File fi;
		FileReader fr = null;
		BufferedReader br;
		try {
			fi = new File (str);
			fr = new FileReader (fi);
			br = new BufferedReader(fr);
        		while((line = br.readLine()) != null) {
        			this.arr.add(Double.parseDouble(line));
        		}
		} catch(Exception e) {
			e.toString();
			e.printStackTrace();
		} finally {
         		try {                    
            			if( null != fr ) {   
               				fr.close();     
            			}	                  
         		} catch (Exception e2) { 
         				e2.toString();
            			e2.printStackTrace();
         		}
      		}
	}
	
}
