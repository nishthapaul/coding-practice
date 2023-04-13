import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class BfsInMatrix {
    public static class Point {
        int x, y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static boolean[][] visited;

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().trim().split(" ");

        int[] ax = new int[]{-1, -1, -1,  0, 0,  1,  1,  1};
        int[] ay = new int[]{-1,  0,  1, -1, 1, -1,  0,  1};

        int rows = Integer.parseInt(inp[0]);
        int cols = Integer.parseInt(inp[1]);
        int ci = Integer.parseInt(inp[2]);
        int cj = Integer.parseInt(inp[3]);
        visited = new boolean[rows][cols];
        int[][] mat = new int[rows][cols];
        Queue<Point> q = new LinkedList<>();
        Point start = new Point(ci, cj);
        mat[ci][cj] = 0;
        q.add(start);
        visited[ci][cj] = true;
        while(!q.isEmpty()) {
            Point p = q.poll();
            for (int i=0; i<8; i++) {
                int neighbourX = p.x + ax[i];
                int neighbourY = p.y + ay[i];
                Point neighbour = new Point(neighbourX, neighbourY);
                if (isValid(neighbour, rows, cols) && isNotVisited(neighbour)) {
                    mat[neighbourX][neighbourY] = mat[p.x][p.y] + 1;
                    q.add(neighbour);
                    visited[neighbourX][neighbourY] = true;
                }
            }
        }
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static boolean isNotVisited(Point neighbour) {
        return !visited[neighbour.x][neighbour.y];
    }

    private static boolean isValid(Point neighbour, int rows, int cols) {
        if ( neighbour.x < 0 || neighbour.y < 0 || neighbour.x >= rows || neighbour.y >= cols) {
            return false;
        }
        return true;
    }
}
// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/waves-b18625d7/

/*
Read string array - ["hello", "all", "folks"]
String[] strData = br.readLine().split(" ");
 */

/*
Print string/int/any array without loop
import java.util.Arrays;
System.out.println(Arrays.toString(strData));
 */

/*
For each loop on string
for(char c: s.toCharArray()) {}
 */

/*
10^9 + 7
import java.math.BigInteger;
BigInteger.TEN.pow(9).add(BigInteger.valueOf(7))
BigInteger doesn't have an empty constructor, initialize with .ONE or .ZERO
 */

/*
import java.util.StringTokenizer;
StringTokenizer st = new StringTokenizer(br.readLine());
 */

/*
convert a line containing some numbers to int array
1. String[] s = br.readLine().split(" ");
int[] a = new int[s.length];
loop on array s to add in array a

2. int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
 */

/*
Array to ArrayList
1. ArrayList<String> array_list = new ArrayList(Collections.singletonList(a));
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
 */

/*
Find min and max of Arrays using Collections
Integer[] num = { 2, 4, 7, 5, 9 };
1.
int min = Collections.min(Arrays.asList(num));
int max = Collections.max(Arrays.asList(num));

2.
int min = Arrays.stream(num).min().getAsInt();
 */

/*
TreeSet<Integer> m = new TreeSet<>();
tree.higher(9); gives the next higher value in set
 */

/*
Baeldung pages
1.
Sum of ArrayList - https://www.baeldung.com/java-stream-sum
https://stackoverflow.com/questions/16242733/sum-all-the-elements-java-arraylist
long intSum = ints.stream().mapToLong(Integer::longValue).sum();

2.
StringTokenizer
https://www.baeldung.com/java-stringtokenizer
 */

/*
https://www.geeksforgeeks.org/submatrix-sum-queries/
 */

/*
https://walkccc.me/LeetCode/problems/1044/?h=longest+duplicate+substring
https://github.com/kamyu104/LeetCode-Solutions/blob/master/README.md
 */