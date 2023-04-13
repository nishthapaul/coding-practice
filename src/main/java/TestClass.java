import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            String[] edge = br.readLine().trim().split(" ");
            addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
        }
        // printGraph();
//        int[] isBlocked = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] isBlocked = new int[]{0, 0, 1, 1, 1, 1, 0, 0};
        boolean[] visited = new boolean[n + 1];

        Map<Integer, Integer> groupOf = new HashMap<>();

        for (int i = 1; i < n + 1; i++) {
            if (isBlocked[i - 1] == 0 && !visited[i]) {
                visited[i] = true;
                int count = 0;
                Stack<Integer> st = new Stack<>();
                st.push(i);
                count++;
                while (!st.isEmpty()) {
                    int source = st.pop();
                    if (isBlocked[source - 1] == 0) {
                        for (int nb : graph.get(source)) {
                            if (!visited[nb]) {
                                count++;
                                st.push(nb);
                                visited[nb] = true;
                            }
                        }
                    }
                }
                System.out.println("i: " + i + "count: " + count);
                groupOf.put(i, count);
            }
        }
        System.out.println(getMapMax(groupOf));
    }

    private static int getMapMax(Map<Integer, Integer> freq) {
        if (freq.isEmpty()) {
            return 0;
        }
        final Collection<Integer> values = freq.values();
        return Collections.max(values);
    }

    private static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
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

//8
//1 2
//1 3
//1 4
//2 5
//2 6
//7 8
//3 4
//0 0 1 1 1 1 0 0


