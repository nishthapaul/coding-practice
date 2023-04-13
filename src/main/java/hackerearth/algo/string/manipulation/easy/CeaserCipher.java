package hackerearth.algo.string.manipulation.easy;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CeaserCipher {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            String a = br.readLine();
            String b = br.readLine();
            sb.append(checkCypher(a, b) + "\n");
        }
        System.out.println(sb);
    }
    static int checkCypher(String a, String b) {
        int c = findCypher(a.charAt(0), b.charAt(0));
        if (a.length() > 1) {
            for (int i=1; i<a.length(); i++) {
                char encr = encrypt(a.charAt(i), c);
                if ( encr != b.charAt(i) ) {
                    return -1;
                }
            }
        }
        return Math.abs((c+26)%26);
    }
    static int findCypher(char a, char b) {
        if (a <= b) {
            return b - a;
        } else { // b > a
            int a1 = a - 'A';
            int b1 = b - 'A';
            int c = b1 + 26 - a1;
            return c%26;
        }
    }
    static char encrypt(char a, int n) {
        int idx = a - 'A';
        int e = (idx + n) % 26;
        return (char)(e + 'A');
    }
}
