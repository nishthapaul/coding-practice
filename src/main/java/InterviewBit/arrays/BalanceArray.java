package InterviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BalanceArray {
    private static int solve(ArrayList<Integer> A) {
        int x = Integer.MAX_VALUE;
        ArrayList<Integer> even = new ArrayList<>(Collections.nCopies(A.size(), 0));
        ArrayList<Integer> odd = new ArrayList<>(Collections.nCopies(A.size(), 0));
        even.set(0, A.get(0));
        odd.set(0, 0);
        for (int i = 1; i < A.size(); i++) {
            if (i % 2 == 0) {
                even.set(i, even.get(i - 1) + A.get(i));
                odd.set(i, odd.get(i - 1));
            } else {
                odd.set(i, odd.get(i - 1) + A.get(i));
                even.set(i, even.get(i - 1));
            }
        }
        System.out.println(odd);
        System.out.println(even);
        int count = 0;
        int lastOdd = odd.get(A.size() - 1);
        int lastEven = even.get(A.size() - 1);
        for (int i = 0; i < A.size(); i++) {
            int totalOdd = odd.get(i);
            int totalEven = even.get(i);
            if (i % 2 == 0) {
                totalEven -= A.get(i);
            } else {
                totalOdd -= A.get(i);
            }
            totalEven = totalEven + ( lastOdd - odd.get(i) );
            totalOdd = totalOdd + ( lastEven - even.get(i) );
            if (totalOdd == totalEven) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1, 6, 4)); // 1, element is 1
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 5, 2, 5, 8)); // 2, element is A[0], A[1]
        System.out.println(solve(A));
    }
}
