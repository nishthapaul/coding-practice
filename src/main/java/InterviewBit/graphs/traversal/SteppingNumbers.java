package InterviewBit.graphs.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumbers {
    public static void main(String[] args) {
        System.out.println(new SteppingNumbers().stepnum(10, 20));
    }

    public ArrayList<Integer> bfs(int n, int A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int front = q.poll();
            if (front >= A && front <= B) {
                ans.add(front);
            }
            if (front < B) {
                if (front % 10 == 0) {
                    q.add(front * 10 + 1);
                } else if (front % 10 == 9) {
                    q.add(front * 10 + 8);
                } else {
                    q.add(front * 10 + (front % 10 - 1));
                    q.add(front * 10 + (front % 10 + 1));
                }
            }
        }
        return ans;
    }

    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == 0) ans.add(0);
        for (int i = 1; i <= 9; i++) {
            ans.addAll(bfs(i, A, B));
        }
        Collections.sort(ans);
        return ans;
    }
}
