package hackerearth.algo.string.manipulation.easy;

import java.io.*;


public class Palindrome_Swapping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String T = br.readLine();
        String S = br.readLine();

        boolean out_ = make_equal(T, S);
        System.out.println(out_ ? "YES" : "NO");

        wr.close();
        br.close();
    }
    static boolean make_equal(String A, String B){
        // Write your code here
        int n = A.length();
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();
        for (int i=0; i<n; i++) {
            if(A.charAt(i) != B.charAt(i)) {
                sbA.append(A.charAt(i));
                sbB.append(B.charAt(i));
            }
        }
        sbB.reverse();
        if (sbA.toString().equals(sbB.toString())) {
            return true;
        } else {
            sbB.reverse();
            return checkPal(sbA.toString(), sbB.toString(), sbA.length());
        }
    }
    static boolean checkPal(String A, String B, int n){
        if (n % 2 == 1) {
            return false;
        }
        System.out.println(A);
        System.out.println(B);
        for (int i=0; i<n/2; i++) {
            char as = A.charAt(i);
            char bs = B.charAt(i);
            char af = A.charAt(n-i-1);
            char bf = B.charAt(n-i-1);
            System.out.println(as + " : " + af);
            System.out.println(bs + " : " + bf);
            if(as != af || bs != bf) {
                if (as != bf || af != bs) {
                    return false;
                }
            }
        }
        return true;
    }
}