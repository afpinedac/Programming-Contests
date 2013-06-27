package WellKnown.Grafos;

public class DFS {

    //test cases
    // O(V+E) -> si esta almacenado en un grafo
    // O(V^2) -> si esta almacenado en una lista o matriz de adyacencia
    static int adj[][] = {{0, 1, 1, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {0, 0, 1, 0}};
    static boolean visited[];

    public static void dfs(int n) {
        visited[n] = true;
        System.out.println(n + 1);
        for (int i = 0; i < n; i++) {
            if (!visited[i] && adj[n][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        int n = adj[0].length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
