package InterviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxMin {
    public static int solve(ArrayList<Integer> A) {
        int finalMax = Math.max(A.get(0), A.get(1));
        int finalMin = Math.min(A.get(0), A.get(1));
        int n = A.size() % 2 == 0 ? A.size() : A.size() - 1;
        for (int i=2; i<n; i+=2) {
            finalMax = Math.max(finalMax, Math.max(A.get(i), A.get(i + 1)));
            finalMin = Math.min(finalMin, Math.min(A.get(i), A.get(i + 1)));
        }
        if ( A.size() % 2 != 0 ) {
            finalMax = Math.max(finalMax, A.get(A.size()-1));
            finalMin = Math.min(finalMin, A.get(A.size()-1));
        }
        return finalMax + finalMin;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-2, 1, -4, 5, 3));
        System.out.println(solve(A));

    }
}
