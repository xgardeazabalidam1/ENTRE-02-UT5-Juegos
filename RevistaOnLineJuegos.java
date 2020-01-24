import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * La clase representa a una tienda on-line en la
 * que se publican los juegos que se van lanzando al mercado
 * 
 * Un objeto de esta clase guarda en un array los juegos 
 *
 * @author - Xanti Gardeazabal Iribarren
 */
public class RevistaOnLineJuegos 
{
    private String nombre;
    private Juego[] juegos;
    private int pos;
    /**
     * Constructor  
     * Crea el array de juegos al tamaño máximo indicado por la constante
     * e inicializa el resto de atributos
     */
    public RevistaOnLineJuegos(String nombre, int n) {
        this.nombre = nombre;
        juegos = new Juego[n];
        pos = 0;
    }

    /**
     * Devuelve true si el array está completo, false en otro caso
     */
    public boolean estaCompleta() {
        return pos == juegos.length;
    }

    /**
     *    Añade un nuevo juego solo si el array no está completo y no existe otro juego
     *    ya con el mismo nombre.  Si no se puede añadir se muestra los mensajes adecuados 
     *    (diferentes en cada caso)
     *    
     *    El juego se añade de tal forma que queda insertado en orden alfabético de título
     *    (de menor a mayor)
     *     !!OJO!! No hay que ordenar ni utilizar ningún algoritmo de ordenación
     *    Hay que insertar en orden 
     *    
     */
    public void add(Juego juego) {
        if(existeJuego(juego.getTitulo()) != -1){
            System.out.print("Ya está ese título añadido");
        }
        else if(estaCompleta()){
            System.out.print("Lista completa");
        }
        else {
            for(int i = 0; i < pos; i++){ 
                if(juegos[i].getTitulo().compareTo(juego.getTitulo()) < 0){
                    juegos[i] = juego;
                    pos++;
                }
            }
        }
    }

    /**
     * Efectúa una búsqueda en el array del juego cuyo titulo se
     * recibe como parámetro. Es indiferente mayúsculas y minúsculas
     * Si existe el juego devuelve su posición, si no existe devuelve -1
     */
    public int existeJuego(String titulo) {
        for (int i = 0; i < pos; i++){
            if (juegos[i].getTitulo().equalsIgnoreCase(titulo)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Representación textual de la revista
     * Utiliza StringBuilder como clase de apoyo.
     * Se incluye el nombre de la  revista on-line.
     * (Ver resultados de ejecución)
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos; i++) {
            sb.append(juegos[i].toString());
        }
        return sb.toString();
    }

    /**
     *  Se puntúa el juego de título indicado con 
     *  la puntuación recibida como parámetro. 
     *  La puntuación es un valor entre 1 y 10 (asumimos esto como correcto)
     *  Si el juego no existe se muestra un mensaje en pantalla
     */
    public void puntuar(String titulo, int puntuacion) {
        if(existeJuego(titulo) == -1){
            puntuar(titulo, puntuacion);
        }
        else if(existeJuego(titulo) != -1){
            System.out.print("No se ha encontrado el juego" + titulo);
        }
    }

    /**
     * Devuelve un array con los nombres de los juegos 
     * con una valoración media mayor a la indicada  
     * 
     * El array se devuelve todo en mayúsculas y ordenado ascendentemente
     */
    public String[] valoracionMayorQue(double valoracion) {
        String[] aprobados = new String[juegos.length];
        int auxpos = 0;
        for(int i = 0; i < pos; i++){
            if(juegos[i].getValoracionMedia() > valoracion){
                aprobados[auxpos] = juegos[i].getTitulo();
                auxpos++;
            }
        }
        return aprobados;
    }

    /**
     * Borrar los juegos del género indicado devolviendo
     * el nº de juegos borrados
     */
    public int borrarDeGenero(Genero genero) {
        int total = 0;
        int p = 0;//posicion
        for(int i = 0; i < pos; i++){
            if(juegos[i].getGenero() == genero){
                for(int j = i + 1; i < pos; i++){
                    juegos[j - 1] = juegos[j];
                    pos --;
                    total++;
                }
            }
        }
        return total;
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
