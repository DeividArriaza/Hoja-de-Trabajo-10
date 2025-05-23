public class Grafo {
    public static final int INF = 9999;
    private int[][] matrizAdyacencia;
    private String[] vertices;

    public Grafo(String[] vertices) {
        this.vertices = vertices;
        matrizAdyacencia = new int[vertices.length][vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                if (i == j)
                    matrizAdyacencia[i][j] = 0;
                else
                    matrizAdyacencia[i][j] = INF;
            }
        }
    }

    public void agregarArco(String origen, String destino, int peso) {
        int i = obtenerIndice(origen);
        int j = obtenerIndice(destino);
        if (i != -1 && j != -1) {
            matrizAdyacencia[i][j] = peso;
        }
    }

    public int[][] obtenerMatriz() {
        return matrizAdyacencia;
    }

    public String[] obtenerVertices() {
        return vertices;
    }

    private int obtenerIndice(String ciudad) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(ciudad)) return i;
        }
        return -1;
    }

}
