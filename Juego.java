/**
 * Un objeto de esta clase guarda informaci�n relativa a un juego
 * 
 * @author - Xanti Gardeazabal Iribarren
 */
public class Juego {
    private static final String SEPARADOR = ":";
    private String titulo;
    private Genero genero;
    private int year;
    private int[] valoraciones;

    /**
     *  Inicializa los atributos a partir de la informaci�n recibida
     *  Esta informaci�n se encuentra en linea
     */
    public Juego(String linea) {
        
    }

    /**
     * accesor t�tulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * accesor g�nero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * accesor year
     */
    public int getYear() {
        return year;
    }

    /**
     * accesor valoraciones
     */
    public int[] getValoraciones() {
        return valoraciones;
    }

    /**
     * total votos emitidos
     */
    public int getVotos() {
        int total = 0;
        for(int i = 0; i < valoraciones.length; i++){
            total = total + valoraciones[i];
        }
        return total;
    }

    /**
     *  obtener valoraci�n media
     */
    public double getValoracionMedia() {
        int media = 0;
        for(int i = 0; i < valoraciones.length; i++){
            media = media + valoraciones[i] * i;
        }
        return media / getVotos();
    }

    /**
     *  Un usuario punt�a el juego con un valor entre 1 y 10 
     */
    public void puntuar(int puntuacion) {
        valoraciones[puntuacion] =+ 1;
    }

    /**
     * Representaci�n textual del juego 
     * (Ver enunciado)
     */
    public String toString() {
        return titulo + "\nG�nero: " + this.genero +
        "| Lanzamiento: " + this.year +
        "\nValoraci�n (" + getVotos() + " votos): "
        + String.format("%.2f", this.getValoracionMedia());
    }

    public static void main(String[] args) {
        Juego juego1 = new Juego(
                "Steep: deportes: 2016  : 0:0:0:0: 0: 0:0:0:12:  10");
        System.out.println(juego1.toString());

        Juego juego2 = new Juego(
                "For the King: estrategia: 2018  : 0:0:0:7: 12: 0:33:13:2: 0");
        System.out.println(juego2.toString());
    }
}
