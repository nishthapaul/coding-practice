package InterviewBit.arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// not the exact question
// copy al elements from 2D matrix A to new 2D matrix B
public class Array_2D {
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            ret.add(A.get((i + B) % A.size()));
        }
        return ret;
    }
    public static void main (String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        A.add(new ArrayList<>(Arrays.asList(11,12,13,14)));
        A.add(new ArrayList<>(Arrays.asList(21,22,23,24)));
        System.out.println(A); // -> [[1, 2, 3, 4], [11, 12, 13, 14], [21, 22, 23, 24]]
        ArrayList<ArrayList<Integer>> B = new ArrayList<>(A.size());
        for (ArrayList<Integer> integers : A) {
            B.add(integers);
        }
        System.out.println(B);
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(rotateArray(a, 2));
    }
}

/*
print arraylist
System.out.println(A) -> [1, 2, 3]
 */