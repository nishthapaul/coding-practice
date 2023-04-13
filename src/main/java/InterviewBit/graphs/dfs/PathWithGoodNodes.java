package InterviewBit.graphs.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class PathWithGoodNodes {
    public static void main(String[] args) {
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 1, 0, 1, 1, 1));
//        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
//        B.add(new ArrayList<>(Arrays.asList(1, 2)));
//        B.add(new ArrayList<>(Arrays.asList(1, 5)));
//        B.add(new ArrayList<>(Arrays.asList(1, 6)));
//        B.add(new ArrayList<>(Arrays.asList(2, 3)));
//        B.add(new ArrayList<>(Arrays.asList(2, 4)));
//
//        System.out.println(new PathWithGoodNodes().solve(A, B, 1)); // ans = 3

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(10, 6)));
        B.add(new ArrayList<>(Arrays.asList(3, 2)));
        B.add(new ArrayList<>(Arrays.asList(12, 7)));
        B.add(new ArrayList<>(Arrays.asList(9, 5)));
        B.add(new ArrayList<>(Arrays.asList(2, 1)));
        B.add(new ArrayList<>(Arrays.asList(8, 3)));
        B.add(new ArrayList<>(Arrays.asList(7, 1)));
        B.add(new ArrayList<>(Arrays.asList(4, 2)));
        B.add(new ArrayList<>(Arrays.asList(6, 3)));
        B.add(new ArrayList<>(Arrays.asList(11, 4)));
        B.add(new ArrayList<>(Arrays.asList(5, 3)));
        B.add(new ArrayList<>(Arrays.asList(13, 11)));

        System.out.println(new PathWithGoodNodes().solve(A, B, 7)); // ans = 5
    }

    int dfs(int root, int parent, Graph g, ArrayList<Integer> A, int cnodes) {
        // leaf
        if (root != 1 && g.adj[root].size() == 1) {
            // bad node
            if (A.get(root - 1) == 0) {
                return 1;
            } else { // good node
                if (cnodes == 0) { // cnodes == 0 -> can't decrement
                    return 0;
                } else {
                    return 1;
                }
            }
        }
        // not leaf
        // good node
        if (A.get(root - 1) == 1) {
            if (cnodes == 0) { // we can't decrement
                return 0;
            } else {
                cnodes--;
            }
        }
        int ans = 0;
        for (int child : g.adj[root]) {
            if (child != parent)
                ans += dfs(child, root, g, A, cnodes);
        }
//        if (A.get(root - 1) == 1) {
//            cnodes++;
//        }
        return ans;
    }

    public int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B, int C) {
        int n = A.size();
        Graph g = new Graph(n);
        for (int i = 0; i < n - 1; i++) {
            g.addEdge(B.get(i).get(0), B.get(i).get(1));
        }
        return dfs(1, -1, g, A, C);
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
