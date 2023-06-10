package mala;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4,5};
        int n = a.length;
        int[] b = new int[n];
        /*
        0 - 1 - 0 - 5,4,3,2
        1 - 2 - 1 - 5,4,3
        2 - 3 - 1,2 - 5,4
        3 - 4 - 1,2,3 - 5
        4 - 5 - 1,2,3,4 - 0
         */
        /* method 1 - if we have to 2 loops, then calculate sum and then traverse and minus*/
        // method 2 - without 2 loops
        int prevSum = 0;
        int nextSum = 0;
        for (int i=0; i<n; i++) {
            b[i] += prevSum;
            prevSum += a[i];

            b[n-i-1] += nextSum;
            nextSum += a[n-i-1];
        }

        System.out.println(Arrays.toString(b));

    }
}
