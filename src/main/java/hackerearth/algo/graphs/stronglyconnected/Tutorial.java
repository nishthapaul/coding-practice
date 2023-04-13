package hackerearth.algo.graphs.stronglyconnected;

/*
You are given a graph with N nodes and M directed edges. Find C − D.
Where,
C Sum of number of nodes in all Strongly Connected Components with odd number of nodes.
D Sum of number of nodes in all Strongly Connected Components with even number of nodes.
 */
import java.util.*;
import java.io.*;
public class Tutorial {
    static class Graph{
        int v;
        ArrayList<Integer> adj[];
        ArrayList<Integer> revAdj[];
        Graph(int v) {
            this.v = v;
            adj = new ArrayList[v+1];
            revAdj = new ArrayList[v+1];
            for(int i=0; i<=v; i++) {
                adj[i] = new ArrayList<>();
                revAdj[i] = new ArrayList<>();
            }
        }
        void addEdge(int u, int v) {
            adj[u].add(v);
            revAdj[v].add(u);
        }
        void printAdjGraph() {
            for(int i=1; i<=v; i++) {
                System.out.print(i + " -> ");
                System.out.print(adj[i] + "\n");
            }
        }
        void printRevAdjGraph() {
            for(int i=1; i<=v; i++) {
                System.out.print(i + " -> ");
                System.out.print(revAdj[i] + "\n");
            }
        }
        void solve() {
            // 1. DFS on graph, create a stack which will have node with highest finishing time will be on top of the stack.
            Stack<Integer> stack = new Stack<>();
            boolean[] visited1 = new boolean[v+1];
            for (int i=1; i<=v; i++) {
                if(!visited1[i]) {
                    dfsMakeStack(stack, visited1, i);
                }
            }
            System.out.println(Arrays.toString(stack.toArray()));
            // 2. Make reverse graph => revAdj list
            // 3. DFS on reverse graph
            boolean[] visited2 = new boolean[v+1];
            int sumOfOdd = 0;
            int sumOfEven = 0;
            while (!stack.isEmpty()) {
                int source = stack.pop();
                System.out.println("source: " + source);
                if (!visited2[source]) {
                    ArrayList<Integer> connectedComponents = new ArrayList<>();
                    dfsFindConnectedComponent(visited2, source, connectedComponents);
                    System.out.println("size: " + connectedComponents.size());
                    if (connectedComponents.size() % 2 == 0) {
                        sumOfEven += connectedComponents.size();
                    } else {
                        sumOfOdd += connectedComponents.size();
                    }
                }
            }
            System.out.println(sumOfOdd - sumOfEven);
        }

        private void dfsFindConnectedComponent(boolean[] visited, int source, ArrayList<Integer> connectedComponents) {
            visited[source] = true;
            System.out.println(revAdj[source]);
            for (int nb : revAdj[source]) {
                if (!visited[nb]) {
                    dfsFindConnectedComponent(visited, nb, connectedComponents);
                }
            }
            connectedComponents.add(source);
        }

        private void dfsMakeStack(Stack<Integer> stack, boolean[] visited, int source) {
            visited[source] = true;
            for (int nb : adj[source]) {
                if (!visited[nb]) {
                    dfsMakeStack(stack, visited, nb);
                }
            }
            stack.push(source);
        }

    }
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ve = br.readLine().trim().split(" ");
        int v = Integer.parseInt(ve[0]);
        int e = Integer.parseInt(ve[1]);
        Graph graph = new Graph(v);
        for (int i=0; i<e; i++) {
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            graph.addEdge(a, b);
        }
        graph.printAdjGraph();
        graph.printRevAdjGraph();
        graph.solve();
    }
}
/*
8 10
1 4
1 3
2 4
3 4
4 5
5 1
2 7
7 6
6 2
8 2
 */