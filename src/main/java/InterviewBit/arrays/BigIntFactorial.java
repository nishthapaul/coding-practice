package InterviewBit.arrays;

import java.math.BigInteger;

public class BigIntFactorial {
    public static String solve(int A) {
        BigInteger prod = BigInteger.ONE;
        for (int i = 2; i <= A; i++) {
            prod = prod.multiply(BigInteger.valueOf(i));
        }
        return prod.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve(6));
    }
}
