package hackerearth.algo.string.manipulation.easy;

import java.util.Arrays;

public class SortSubstringDesc {
    public static void main(String[] args) {
        String s = "abcdef";
        int m = 1, n = 3;
        System.out.println(sortSubstring(s, m, n));
    }

    private static String sortSubstring(String s, int m, int n) {
        String s1 = s.substring(0, m);
        String s2 = s.substring(m, n + 1);
        String s3 = s.substring(n + 1);
        System.out.println(s1 + " " + s2 + " " + s3);
        char[] chars = s2.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder(new String(chars));
        sb.reverse();
        return s1 + sb + s3;
    }
}
