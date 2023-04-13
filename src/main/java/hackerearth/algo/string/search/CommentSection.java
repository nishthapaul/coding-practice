package hackerearth.algo.string.search;/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;


class CommentSection {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            System.out.println("n:" + n);
            n++;
            System.out.println(n);
            long roots[] = getNums(n);
            System.out.println(roots[0]  + " * " + roots[1] + " = " + roots[0]*roots[1]);
            sb.append(roots[0] + roots[1] - 2 + "\n");
        }
        System.out.println(sb);
    }

    static long[] getNums(long n) {
        long num1 = (long) Math.sqrt(n);
        System.out.println(num1);
        long num2 = num1;

        while (num1 * num2 >= n) {
            if (num1 * num2 == n) {
                return new long[]{num1, num2};
            } else if (num1 * num2 < n) {
                num2++;
            } else {
                num1--;
            }
        }
        return new long[]{-1, -1};
    }
}
