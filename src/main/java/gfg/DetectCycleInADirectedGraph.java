package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;

public class DetectCycleInADirectedGraph {
    // Function to detect cycle in an directed graph.
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<>());
        }
        while (m-- > 0) {
            String[] path = br.readLine().split(" ");
            int u = Integer.parseInt(path[0]);
            int v = Integer.parseInt(path[1]);
            adj.get(u).add(v);
        }
        System.out.println(detectCycle(n, adj));
    }


    public static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(i, visited, recStack, adj)) {
                    return true; // cycle found
                }
            }
        }

        return false; // no cycle found
    }

    private static boolean detectCycleUtil(int i, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj) {
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        ArrayList<Integer> neighbour = adj.get(i);

        for (Integer nb : neighbour)
            if (detectCycleUtil(nb, visited, recStack, adj))
                return true;

        recStack[i] = false;

        return false;

    }
}
