package InterviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumFromBothSides {
    public static int solve(ArrayList<Integer> A, int B) {
        int currSum = 0;
        int leftIndex = 0;
        for (; leftIndex<A.size() && leftIndex<B; leftIndex++) {
            currSum += A.get(leftIndex);
        }
        leftIndex--;
        System.out.println(currSum);
        int maxSum = currSum;
        for (int j=A.size()-1; j>=0 && leftIndex > -1; j--) {
            currSum = currSum - A.get(leftIndex) + A.get(j);
            maxSum = Math.max(currSum, maxSum);
            leftIndex--;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, -2, 3, 1, 2));
        int B = 3;
        System.out.println("ans : " + solve(A, B));
    }
}
