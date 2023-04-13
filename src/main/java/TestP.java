import java.util.*;

class TestP {
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String args[]) throws Exception {
//        int n = 5;
//        int[][] edges = new int[][]{{1, 4}, {3, 4}, {1, 5}, {1, 2}};

        int n = 4;
        int[][] edges = new int[][]{{1, 4}, {3, 2}, {1, 2}};

        graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            addEdge(edges[i][0], edges[i][1]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            removeEdge(edges[i][0], edges[i][1]);
            for (int j = i + 1; j < n - 1; j++) {
                removeEdge(edges[j][0], edges[j][1]);
                printGraph();
                int s = solveBFS(n);
                ans = Math.min(ans, s);
                addEdge(edges[j][0], edges[j][1]);
            }
            addEdge(edges[i][0], edges[i][1]);
        }
        System.out.println(ans);
    }

    private static int solveBFS(int n) {
        int x1 = 0, x2 = 0, x3 = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(1);
        x1 = x1 ^ 1;
        visited[1] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            ArrayList<Integer> neighbours = graph.get(node);
            for (int nb : neighbours) {
                if (!visited[nb]) {
                    x1 = x1 ^ nb;
                    q.add(nb);
                    visited[nb] = true;
                }
            }
        }
        for (int i = 2; i < n + 1; i++) {
            if (!visited[i]) {
                q.add(i);
                x2 = x2 ^ i;
                visited[i] = true;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    ArrayList<Integer> neighbours = graph.get(node);
                    for (int nb : neighbours) {
                        if (!visited[nb]) {
                            x2 = x2 ^ nb;
                            q.add(nb);
                            visited[nb] = true;
                        }
                    }
                }
                break;
            }
        }
        for (int i = 2; i < n + 1; i++) {
            if (!visited[i]) {
                q.add(i);
                x3 = x3 ^ i;
                visited[i] = true;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    ArrayList<Integer> neighbours = graph.get(node);
                    for (int nb : neighbours) {
                        if (!visited[nb]) {
                            x3 = x3 ^ nb;
                            q.add(nb);
                            visited[nb] = true;
                        }
                    }
                }
                break;
            }
        }
        int max123 = Collections.max(Arrays.asList(x1, x2, x3));
        int min123 = Collections.min(Arrays.asList(x1, x2, x3));

        return max123 - min123;
    }

    private static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static void removeEdge(int u, int v) {
        graph.get(u).remove(new Integer(v));
        graph.get(v).remove(new Integer(u));
    }

    static void printGraph() {
        System.out.println("size: " + graph.size());
        for (int i = 1; i < graph.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(" -> " + graph.get(i).get(j));
            }
            System.out.println();
        }
    }
}

// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/monk-and-the-islands/