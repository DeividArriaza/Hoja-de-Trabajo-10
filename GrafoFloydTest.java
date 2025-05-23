import org.junit.Test;
import static org.junit.Assert.*;

public class GrafoFloydTest {

    @Test
    public void testAgregarArco() {
        String[] ciudades = {"A", "B", "C"};
        Grafo grafo = new Grafo(ciudades);
        grafo.agregarArco("A", "B", 5);

        int[][] matriz = grafo.obtenerMatriz();
        assertEquals(5, matriz[0][1]);
        assertEquals(0, matriz[0][0]);
        assertEquals(Grafo.INF, matriz[1][0]);
    }

    @Test
    public void testAgregarArcoInvalido() {
        String[] ciudades = {"A", "B"};
        Grafo grafo = new Grafo(ciudades);
        grafo.agregarArco("A", "Z", 10);

        int[][] matriz = grafo.obtenerMatriz();
        assertEquals(Grafo.INF, matriz[0][1]);
    }

    @Test
    public void testFloydWarshall() {
        String[] ciudades = {"A", "B", "C"};
        Grafo grafo = new Grafo(ciudades);
        grafo.agregarArco("A", "B", 3);
        grafo.agregarArco("B", "C", 2);
        grafo.agregarArco("A", "C", 10);

        int[][] resultado = FloydWarshall.floyd(grafo.obtenerMatriz());

        assertEquals(5, resultado[0][2]);
        assertEquals(3, resultado[0][1]);
    }

    @Test
    public void testEncontrarCentro() {
        String[] ciudades = {"A", "B", "C", "D", "E"};
        Grafo grafo = new Grafo(ciudades);
        grafo.agregarArco("A", "B", 3);
        grafo.agregarArco("A", "D", 7);
        grafo.agregarArco("B", "C", 1);
        grafo.agregarArco("B", "E", 8);
        grafo.agregarArco("C", "D", 2);
        grafo.agregarArco("D", "E", 3);
        grafo.agregarArco("E", "A", 4);

        int[][] resultado = FloydWarshall.floyd(grafo.obtenerMatriz());
        int centro = FloydWarshall.encontrarCentro(resultado);

        assertTrue(centro >= 0 && centro < ciudades.length);
    }
}
