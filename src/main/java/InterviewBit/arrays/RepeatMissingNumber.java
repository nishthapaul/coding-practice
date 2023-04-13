package InterviewBit.arrays;

import java.util.*;

public class RepeatMissingNumber {
    public static ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        Set<Integer> set = new HashSet<>();
        int A = 0;
        int B = a.get(0) ^ 1;
        set.add(a.get(0));
        boolean isAFound = false;
        for (int i=1; i<a.size(); i++) {
            if (!isAFound && set.contains(a.get(i))) {
                A = a.get(i);
                isAFound = true;
                B = B ^ (i+1);
            } else {
                set.add(a.get(i));
                B = B ^ (i+1) ^ a.get(i);
            }
        }
        return new ArrayList<Integer>(Arrays.asList(A, B));
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 3));
        System.out.println(repeatedNumber(A));
    }
}

/*
How to find repeated element - HashSet
How to find missing element -
We know that elements have to be from 1 to n
So either take total sum = n*n+1/2, but ismai long ka chakkar hoga
So, use xor operator
sbka except the repeated element ka xor with 1 to n ka xor - the result variable will contain missing element
 */
