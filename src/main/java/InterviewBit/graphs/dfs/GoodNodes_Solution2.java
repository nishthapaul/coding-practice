package InterviewBit.graphs.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Very good question
public class GoodNodes_Solution2 {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 1, 2));
        System.out.println(new GoodNodes_Solution2().solve(A));
    }

    public int solve(ArrayList<Integer> A) {
        int v = A.size();
        Graph g = new Graph(v);
        // NOTE: this loop is not starting from i=0, it is starting from i=1
        // hmne 1 se jane vala edge consider nahi kiya hai
        for (int i = 1; i < v; i++) {
            g.addEdge(i + 1, A.get(i));
            g.addEdge(A.get(i), i + 1);
        }
        boolean visited[] = new boolean[v + 1];
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < v + 1; i++) {
            if (!visited[i]) {
                cnt++;
                visited[i] = true;
                q.add(i);
                while (!q.isEmpty()) {
                    int front = q.poll();
                    for (int nb : g.adj[front]) {
                        if (!visited[nb]) {
                            q.add(nb);
                            visited[nb] = true;
                        }
                    }
                }
            }
        }
        return cnt - 1;
    }

    class Graph {
        int v;
        ArrayList<Integer> adj[];

        Graph(int v) {
            this.v = v;
            adj = new ArrayList[v + 1];
            for (int i = 1; i < v + 1; i++) {
                adj[i] = new ArrayList<Integer>();
            }
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }
    }
}