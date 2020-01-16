import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * La clase representa a una tienda on-line en la
 * que se publican los juegos que se van lanzando al mercado
 * 
 * Un objeto de esta clase guarda en un array los juegos 
 *
 * @author -
 */
public class RevistaOnLineJuegos 
{
	private String nombre;
	private Juego[] juegos;
	private int total;

	/**
	 * Constructor  
	 * Crea el array de juegos al tama�o m�ximo indicado por la constante
	 * e inicializa el resto de atributos
	 */
	public RevistaOnLineJuegos(String nombre, int n) {
		 
	}

	/**
	 * Devuelve true si el array est� completo, false en otro caso
	 */
	public boolean estaCompleta() {
		
	    return true;
	}

	/**
	 *    A�ade un nuevo juego solo si el array no est� completo y no existe otro juego
	 *    ya con el mismo nombre.  Si no se puede a�adir se muestra los mensajes adecuados 
	 *    (diferentes en cada caso)
	 *    
	 *    El juego se a�ade de tal forma que queda insertado en orden alfab�tico de t�tulo
	 *    (de menor a mayor)
	 *     !!OJO!! No hay que ordenar ni utilizar ning�n algoritmo de ordenaci�n
	 *    Hay que insertar en orden 
	 *    
	 */
	public void add(Juego juego) {
		 

	}

	 

	/**
	 * Efect�a una b�squeda en el array del juego cuyo titulo se
	 * recibe como par�metro. Es ndiferente may�sculas y min�sculas
	 * Si existe el juego devuelve su posici�n, si no existe devuelve -1
	 */
	public int existeJuego(String titulo) {
		 
	    
		return 0;

	}

	/**
	* Representaci�n textual de la revista
	* Utiliza StringBuilder como clase de apoyo.
	* Se incluye el nombre de la  revista on-line.
	* (Ver resultados de ejecuci�n)
	*/
	public String toString() {
		
	    
	    
		return "";

	}

	/**
	 *  Se punt�a el juego de t�tulo indicado con 
	 *  la puntuaci�n recibida como par�metro. 
	 *  La puntuaci�n es un valor entre 1 y 10 (asumimos esto como correcto)
	 *  Si el juego no existe se muestra un mensaje en pantalla
	 */
	public void puntuar(String titulo, int puntuacion) {
		 

	}

	/**
	* Devuelve un array con los nombres de los juegos 
	* con una valoraci�n media mayor a la indicada  
	* 
	* El array se devuelve todo en may�sculas y ordenado ascendentemente
	*/
	public String[] valoracionMayorQue(double valoracion) {
		 
	    
	    
		return null;

	}

	/**
	 * Borrar los juegos del g�nero indicado devolviendo
	 * el n� de juegos borradas
	 */
	public int borrarDeGenero(Genero genero) {
		
	    
		return 0;

	}

	/**
	* Lee de un fichero de texto los datos de los juegos
	* con ayuda de un objeto de la  clase Scanner
	* y los guarda en el array. 
	*/
	public void leerDeFichero() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("juegos.txt"));
			while (sc.hasNextLine()) {
				Juego juego = new Juego(sc.nextLine());
				this.add(juego);

			}

		} catch (IOException e) {
			System.out.println("Error al leer del fichero");
		} finally {
			sc.close();
		}

	}

}
