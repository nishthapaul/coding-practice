package InterviewBit.graphs.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_GraphClass {
    public static void main(String[] args) {
        int v = 5;
        Graph g = new Graph(v);

        g.addEdge(1, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 1);

        g.printGraph();

        int source = 1;
        System.out.println("bfs ::: " + g.bfs(source));
    }

    private static class Graph {
        private final int v;
        private final ArrayList<Integer> adj[];

        Graph(int v) {
            this.v = v;
            adj = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
        }

        void printGraph() {
            for (int i = 1; i <= v; i++) {
                System.out.println("i: " + i + " -> " + adj[i]);
            }
        }

        ArrayList<Integer> bfs(int s) {
            ArrayList<Integer> traversal = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[v + 1];
            q.add(s);
            visited[s] = true;
            while (!q.isEmpty()) {
                int front = q.poll();
                traversal.add(front);
                ArrayList<Integer> neighbours = adj[front];
                for (int neighbour : neighbours) {
                    if (!visited[neighbour]) {
                        q.add(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }
            return traversal;
        }
    }
}
