package hackerearth.algo.graphs.bfs.easy;

import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.*;

class TheFlightPlan {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int t = Integer.parseInt(firstLine[2]);
        int c = Integer.parseInt(firstLine[3]);
        Graph graph = new Graph(n);
        for (int i=0; i<m; i++) {
            String[] uv = br.readLine().trim().split(" ");
            graph.addEdge(Integer.parseInt(uv[0]), Integer.parseInt(uv[1]));
        }
        String[] xy = br.readLine().trim().split(" ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);
        graph.printGraph();
        graph.sortEdges();
        System.out.println("after sorting edges");
        graph.printGraph();
        graph.solve(x, y);
    }
    static class Graph {
        int v;
        ArrayList<Integer> adj[];
        Graph (int v) {
            this.v = v;
            adj = new ArrayList[v + 1];
            for (int i=0; i<(v+1); i++) {
                adj[i] = new ArrayList<Integer>();
            }
        }
        void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }
        void sortEdges() {
            for (int i=0; i<(v+1); i++) {
                Collections.sort(adj[i]);
            }
        }
        void printGraph() {
            System.out.println("printing graph");
            for (int i=0; i<(v+1); i++) {
                final ArrayList<Integer> neighboursOfI = adj[i];
                System.out.print("Node : " + i + " -> ");
                for (int nb : neighboursOfI) {
                    System.out.print(nb + " , ");
                }
                System.out.println(" ");
            }
        }

        void solve(int x, int y) {
            int parent[] = new int[v+1];
            int dist[] = new int[v+1];
            for (int i=0; i<v+1; i++) {
                parent[i] = 0;
                dist[i] = 0;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(x);
            while (!q.isEmpty()) {
                int node = q.poll();
                System.out.println("polled node: " + node);
                ArrayList<Integer> neighbours = adj[node];
                for (int nb : neighbours) {
                    if (nb == x) {
                        continue;
                    }
                    if (dist[nb] > dist[node] + 1 || dist[nb] == 0) {
                        dist[nb] = dist[node] + 1;
                        parent[nb] = node;
                        q.add(nb);
                    }
                }
            }
            System.out.println(dist[y] + 1);
            ArrayList<Integer> res = new ArrayList<>();
            res.add(y);
            int new_parent = parent[y];
            while (new_parent != x && new_parent != 0) {
                res.add(new_parent);
                new_parent = parent[new_parent];
            }
            res.add(x);
            StringBuilder path = new StringBuilder();
            for(int i=res.size()-1; i>=0; i--) {
                path.append(res.get(i)).append(" ");
            }
            System.out.println(path);
        }
    }
}

// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/traffic-light-2-ee27ba45/