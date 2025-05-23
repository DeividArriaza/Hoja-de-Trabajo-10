public class FloydWarshall {
    public static int[][] floyd(int[][] grafo) {
        int n = grafo.length;
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = grafo[i][j];

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        return dist;
    }

    public static int encontrarCentro(int[][] distancias) {
        int n = distancias.length;
        int centro = -1;
        int menorExcentricidad = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int excentricidad = 0;
            for (int j = 0; j < n; j++) {
                if (distancias[i][j] != Grafo.INF && distancias[i][j] > excentricidad) {
                    excentricidad = distancias[i][j];
                }
            }

            if (excentricidad < menorExcentricidad) {
                menorExcentricidad = excentricidad;
                centro = i;
            }
        }

        return centro;
    }
}
