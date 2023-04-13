package InterviewBit.graphs.traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CaptureRegionsOnBoard {
    int cx[] = new int[]{1, 0, 0, -1};
    int cy[] = new int[]{0, 1, -1, 0};

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList('X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'X', 'X')));
        A.add(new ArrayList<>(Arrays.asList('X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'X')));
        A.add(new ArrayList<>(Arrays.asList('O', 'X', 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O')));
        A.add(new ArrayList<>(Arrays.asList('O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'O')));
        A.add(new ArrayList<>(Arrays.asList('O', 'X', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'X')));
        A.add(new ArrayList<>(Arrays.asList('O', 'X', 'X', 'X', 'O', 'X', 'X', 'O', 'X', 'O')));
        A.add(new ArrayList<>(Arrays.asList('O', 'O', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O')));
        int r = A.size();
        int c = A.get(0).size();
        new CaptureRegionsOnBoard().solve(A);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(A.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

    public void solve(ArrayList<ArrayList<Character>> A) {
        /*
        Idea -> Whatever Os are connected to boundary vale Os are not surrounded by X
        Boundary ke sb 'O' se start karo and zo O mile usko 'B' bana do (using bfs/dfs)
        Phir bache huye Os will not be in contact will boundary vale Os, so make them X
        Phir, B ko vapus O bana do
         */
        int r = A.size();
        int c = A.get(0).size();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ((i == 0 || j == 0 || i == r - 1 || j == c - 1) && A.get(i).get(j) == 'O') {
                    A.get(i).set(j, 'B');
                    bfs(A, i, j, r, c);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(A.get(i).get(j) == 'O') {
                    A.get(i).set(j, 'X');
                }
                else if (A.get(i).get(j) == 'B') {
                    A.get(i).set(j, 'O');
                }
            }
        }
    }

    void bfs(ArrayList<ArrayList<Character>> A, int i, int j, int r, int c) {
        boolean visited[][] = new boolean[r][c];
        Point source = new Point(i, j);
        Queue<Point> q = new LinkedList<>();
        q.add(source);
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Point front = q.poll();
            for (int z = 0; z < 4; z++) {
                Point neighbour = new Point(front.x + cx[z], front.y + cy[z]);
                if (isPointValid(neighbour, r, c) && A.get(neighbour.x).get(neighbour.y) == 'O' && !visited[neighbour.x][neighbour.y]) {
                    A.get(neighbour.x).set(neighbour.y, 'B');
                    q.add(neighbour);
                    visited[neighbour.x][neighbour.y] = true;
                }
            }
        }
    }

    private boolean isPointValid(Point p, int r, int c) {
        return (p.x >= 0 && p.x < r) && (p.y >= 0 && p.y < c);
    }

    public class Point {
        int x, y;

        Point(int i, int j) {
            this.x = i;
            this.y = j;
        }

    }
}
