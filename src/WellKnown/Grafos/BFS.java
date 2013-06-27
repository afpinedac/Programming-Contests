package WellKnown.Grafos;

import java.util.ArrayList;

//test cases
// O(V+E) -> si esta almacenado en un grafo
// O(V^2) -> si esta almacenado en una lista o matriz de adyacencia
public class BFS {

    static int adj[][] = {{0, 1, 1, 0, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 1, 0}, {0, 0, 1, 0, 0}, {1, 0, 0, 0, 0}};
    static boolean visited[];

    public static void main(String[] args) {


        int n = adj[0].length;
        visited = new boolean[n];
        ArrayList<Integer> q = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int c = q.get(0);
                    q.remove(0);
                    System.out.println(c + 1);
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && adj[c][j] == 1) {
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
    }
}
