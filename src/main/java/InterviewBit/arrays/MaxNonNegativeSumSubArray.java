package InterviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSumSubArray {
    static ArrayList<Integer> maxNonNegativeSubArray(ArrayList<Integer> A){
        int currStartIndex = 0;
        ArrayList<Integer> currSubArray = new ArrayList<>();
        long currSum = 0;
        ArrayList<Integer> maxSumSubArray = new ArrayList<>();
        long maxSum = 0;
        for (int i=0; i < A.size(); i++) {
            if (A.get(i) >= 0) {
                currSum += A.get(i);
                currSubArray.add(A.get(i));
            }
            if ( A.get(i) < 0 || (i == A.size()-1 && A.get(i) >= 0) ) {
                // if (currSum < maxSum) - no change
                if (maxSum < currSum) { // update maxSum
                    maxSum = currSum;
                    maxSumSubArray = currSubArray;
                } else if (maxSum == currSum) { // tie 1
                    // check other aspects - 1. size
                    // if (maxSumSubArray.size() > currSubArray.size()) - no change
                    if (maxSumSubArray.size() < currSubArray.size()) {
                        maxSum = currSum;
                        maxSumSubArray = currSubArray;
                    }
                    // size equal hone pe start e=index check karne ki zarurat nahi hai because current sub array start index will be
                    // more than max sub array
                }
                currSum = 0;
                currSubArray = new ArrayList<>();
            }
        }
        return maxSumSubArray;
    }
    public static void main (String[] args) {
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,-5, -9));
        System.out.println(maxNonNegativeSubArray(A));
    }


}
