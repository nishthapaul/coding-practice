package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUnDirectedGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(i, new ArrayList<>());
        }
        while (m-- > 0) {
            String[] path = br.readLine().split(" ");
            int u = Integer.parseInt(path[0]);
            int v = Integer.parseInt(path[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(isCycle(n, adj));

    }
    // Function to detect cycle in an undirected graph.
    static boolean visited[];
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new boolean[V];
        for(int i=0; i<V; i++) {
            System.out.println("i: " + i);
            if ( !visited[i] && bfs(V, adj, i) ){
                System.out.println("returning true for " + i);
                return true;
            }
        }
        return false;
    }
    static boolean bfs(int V, ArrayList<ArrayList<Integer>> adj, int i) {
        Queue<Integer> q = new LinkedList<>();
        int parent[] = new int[V];
        q.add(i);
        visited[i] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.println("node: " + node);
            ArrayList<Integer> neighbours = adj.get(node);
            for (int nb : neighbours) {
                System.out.println("nb: " + nb);
                if (nb != parent[node]) {
                    System.out.println("nb is not parent of node");
                    if (visited[nb]) {
                        System.out.println("nb is already visited");
                        return true;
                    }
                    System.out.println("nb is not visited, so adding to queue");
                    q.add(nb);
                    visited[nb] = true;
                    parent[nb] = node;
                }
            }
        }
        return false;
    }
}