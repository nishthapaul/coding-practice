import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class NoOfIslandsBfs {
    static int[] ax = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] ay = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while ((tc--) > 0) {
            String[] nm = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int[][] pool = new int[n][m];
            int[][] poolAns = new int[n][m];
            for (int i = 0; i < n; i++) {
                pool[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            Map<Integer, Integer> freq = new HashMap<>();
            int count = 0;
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (pool[i][j] == 1 && !visited[i][j]) {
                        count++;
                        freq.put(count, 1);
                        poolAns[i][j] = count;
                        visited[i][j] = true;
                        // start bfs at i, j
                        Point start = new Point(i, j);
                        Queue<Point> q = new LinkedList<>();
                        q.add(start);
                        while (!q.isEmpty()) {
                            Point front = q.poll();
                            for (int k = 0; k < 8; k++) {
                                int neighbourX = front.x + ax[k];
                                int neighbourY = front.y + ay[k];
                                Point neighbour = new Point(neighbourX, neighbourY);
                                if (isValid(neighbour, n, m) && !visited[neighbourX][neighbourY] && pool[neighbourX][neighbourY] == 1) {
                                    visited[neighbourX][neighbourY] = true;
                                    poolAns[neighbourX][neighbourY] = count;
                                    freq.put(count, freq.get(count) + 1);
                                    q.add(neighbour);
                                }
                            }
                        }
                    }
                }
            }
            printPool(poolAns, n, m);
            System.out.println(count);
            System.out.println(getMapMax(freq));
        }
    }

    private static int getMapMax(Map<Integer, Integer> freq) {
        if (freq.isEmpty()) {
            return 0;
        }
        final Collection<Integer> values = freq.values();
        return Collections.max(values);
    }

    private static boolean isValid(Point neighbour, int rows, int cols) {
        if (neighbour.x < 0 || neighbour.y < 0 || neighbour.x >= rows || neighbour.y >= cols) {
            return false;
        }
        return true;
    }

    public static void printPool(int[][] pool, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(pool[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

//    public static ArrayList<ArrayList<Integer>> graph;
//    private static void addEdge(int u, int v) {
//        graph.get(u).add(v);
//        graph.get(v).add(u);
//    }
//
//    static void printGraph() {
//        System.out.println("size: " + graph.size());
//        for (int i = 1; i < graph.size(); i++) {
//            System.out.println("\nAdjacency list of vertex" + i);
//            System.out.print("head");
//            for (int j = 0; j < graph.get(i).size(); j++) {
//                System.out.print(" -> " + graph.get(i).get(j));
//            }
//            System.out.println();
//        }
//     }
}

// https://www.geeksforgeeks.org/breadth-first-traversal-bfs-on-a-2d-array/
// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/oliver-and-the-battle-1/