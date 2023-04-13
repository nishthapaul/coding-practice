package InterviewBit.graphs.basic;

import java.util.ArrayList;
import java.util.Stack;

public class DFS_GraphClass_Iterative {

    public static void main(String[] args) {
        int v = 5;
        Graph g = new Graph(v);

        g.addEdge(1, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 1);

        int source = 1;
        System.out.println(g.dfs(source));
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

        public ArrayList<Integer> dfs(int source) {
            ArrayList<Integer> traversal = new ArrayList<>();
            boolean[] visited = new boolean[v+1];
            Stack<Integer> s = new Stack();
            s.push(source);
            visited[source] = true; 
            while (!s.isEmpty()) {
                int top = s.pop();
                traversal.add(top);
                ArrayList<Integer> neighbours = adj[top];
                for (int neighbour : neighbours) { // ulta chalao for copy approach
                    if (!visited[neighbour]) {
                        s.push(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }
            return traversal;
        }
    }
}
