import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BfsInGraph {
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while ((tc--) > 0) {
            String[] nm = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            graph = new ArrayList<>(n + 1);
            for (int i = 0; i < n+1; i++)
                graph.add(new ArrayList<>());
            int[] dist = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                dist[i] = 0;
            }
            while ((m--) > 0) {
                String[] edge = br.readLine().trim().split(" ");
                addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            while (!q.isEmpty()) {
                int node = q.poll();
                ArrayList<Integer> neighbours = graph.get(node);
                for (int nb : neighbours) {
                    if (nb == 1) {continue;}
                    if (dist[nb] == 0) {
                        dist[nb] = dist[node] + 1;
                        q.add(nb);
                    } else if (dist[nb] > dist[node] + 1) {
                        dist[nb] = dist[node] + 1;
                        q.add(nb);
                    }
                }
            }
            System.out.println(dist[n]);
        }
    }
    private static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
}

// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/monk-and-the-islands/