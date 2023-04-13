package InterviewBit.graphs.traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WaterFlow {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> city = new ArrayList<>();
        city.add(new ArrayList<>(Arrays.asList(1, 2, 2, 3, 5)));
        city.add(new ArrayList<>(Arrays.asList(3, 2, 3, 4, 4)));
        city.add(new ArrayList<>(Arrays.asList(2, 4, 5, 3, 1)));
        city.add(new ArrayList<>(Arrays.asList(6, 7, 1, 4, 5)));
        city.add(new ArrayList<>(Arrays.asList(5, 1, 1, 2, 4)));
        // answer 7

//        city.add(new ArrayList<>(Arrays.asList(2, 2)));
//        city.add(new ArrayList<>(Arrays.asList(2, 2)));
        // answer 2

        System.out.println(solve(city));
    }

    private static int solve(ArrayList<ArrayList<Integer>> A) {
        int cx[] = new int[]{0, 1, -1, 0};
        int cy[] = new int[]{1, 0, 0, -1};
        int r = A.size();
        int c = A.get(0).size();
        int count = 0;
        boolean blue[][] = new boolean[r][c];
        boolean red[][] = new boolean[r][c];

        Queue<Point> q1 = new LinkedList<>();
        Queue<Point> q2 = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            blue[i][0] = true;
            q1.add(new Point(i, 0));
            red[i][c - 1] = true;
            q2.add(new Point(i, c - 1));
        }
        for (int i = 0; i < c; i++) {
            blue[0][i] = true;
            q1.add(new Point(0, i));
            red[r - 1][i] = true;
            q2.add(new Point(r - 1, i));
        }
        System.out.println("before bfs blue");
        print(blue, r, c);
        System.out.println("before bfs red");
        print(red, r, c);

        bfs(A, cx, cy, r, c, blue, q1);
        bfs(A, cx, cy, r, c, red, q2);

        System.out.println("after bfs blue");
        print(blue, r, c);

        System.out.println("after bfs red");
        print(red, r, c);

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(blue[i][j] && red[i][j])
                    count++;
            }
        }

        return count;
    }

    private static void bfs(ArrayList<ArrayList<Integer>> A, int[] cx, int[] cy, int r, int c, boolean[][] water, Queue<Point> q) {
        while (!q.isEmpty()) {
            Point front = q.poll();
            System.out.println("front: A[" + front.x + "][" + front.y + "]");
            for (int cp = 0; cp < 4; cp++) {
                Point neighbour = new Point(front.x + cx[cp], front.y + cy[cp]);
                System.out.println("Neighbour: A[" + neighbour.x + "][" + neighbour.y + "]");
                if (isPointValid(neighbour, r, c) && !water[neighbour.x][neighbour.y] && A.get(front.x).get(front.y) <= A.get(neighbour.x).get(neighbour.y)) {
                    System.out.println("here");
                    q.add(neighbour);
                    water[neighbour.x][neighbour.y] = true;
                }
            }
        }
    }


    private static void print(boolean[][] A, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static boolean isPointValid(Point p, int r, int c) {
        return (p.x >= 0 && p.x < r) && (p.y >= 0 && p.y < c);
    }


    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}