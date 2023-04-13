package InterviewBit.graphs.dfs;

import java.util.ArrayList;
import java.util.Arrays;

// Very good question
public class GoodNodes_Solution1 {
    boolean good[];

    public void dfs(int node, ArrayList<Integer> A, boolean visited[]) {
        visited[node] = true;
        int to = A.get(node - 1);
        if (!visited[to] && !good[to]) {
            dfs(to, A, visited);
        }
        if (good[to]) {
            good[node] = true;
        }
    }

    public void dfs2(int node, ArrayList<Integer> A, boolean visited[]) {
        good[node] = true;
        int to = A.get(node - 1);
        if (!good[to]) {
            dfs2(to, A, visited);
        }
    }

    public int solve(ArrayList<Integer> A) {
        int v = A.size();
        good = new boolean[v + 1];
        int cnt = 0;
        boolean visited[] = new boolean[v + 1];
        good[1] = true;
        visited[1] = true;
        for (int i = 2; i < v + 1; i++) {
            if (!visited[i]) {
                dfs(i, A, visited);
                if (!good[i]) {
                    cnt++;
                    dfs2(i, A, visited);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 1, 2));

        System.out.println(new GoodNodes_Solution1().solve(A));
    }
}
