public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"A", "B", "C", "D", "E"}; // A: Guatemala, B: Zacapa, etc.
        Grafo grafo = new Grafo(ciudades);

        grafo.agregarArco("A", "B", 3);
        grafo.agregarArco("A", "D", 7);
        grafo.agregarArco("B", "C", 1);
        grafo.agregarArco("B", "E", 8);
        grafo.agregarArco("C", "D", 2);
        grafo.agregarArco("D", "E", 3);
        grafo.agregarArco("E", "A", 4);

        int[][] resultado = FloydWarshall.floyd(grafo.obtenerMatriz());

        System.out.println("Matriz de distancias más cortas:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado.length; j++) {
                if (resultado[i][j] == Grafo.INF)
                    System.out.print("∞ ");
                else
                    System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }

        int centro = FloydWarshall.encontrarCentro(resultado);
        System.out.println("El centro del grafo es la ciudad: " + ciudades[centro]);
    }
}
