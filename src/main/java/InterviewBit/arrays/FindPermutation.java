package InterviewBit.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class FindPermutation {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ArrayList<Integer> findPerm(final String S, int n) {
        ArrayList<Integer> A = new ArrayList<Integer>(Collections.nCopies(n, 0));
        int countD = 0;
        if (S.charAt(0) != 'D') {
            A.set(0, 1);
        } else {
            for (int i=0; i<n-1; i++) {
                if (S.charAt(i) == 'D') {
                    countD++;
                }
            }
            countD++;
            A.set(0, countD);
        }
        int copyN = n;
        for (int i=S.length()-1; i>=0; i--) {
            if (S.charAt(i) == 'I') {
                if (copyN == countD) {
                    copyN--;
                }
                A.set(i+1, copyN);
                copyN--;
            }
        }
        for (int i=0; i<S.length(); i++) {
            System.out.println("i: " + i);
            if (S.charAt(i) == 'D') {
                if (copyN == countD) {
                    copyN--;
                }
                A.set(i+1, copyN);
                copyN--;
            }
        }
        return A;
    }

    public static void main(String[] args) {
//        System.out.println(findPerm("IDIDI", 6));
        System.out.println(findPerm("DIDID", 6));
//        System.out.println(findPerm("DDD", 4));
    }
}
