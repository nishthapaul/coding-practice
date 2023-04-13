package hackerearth.algo.string.search;

import java.util.Arrays;

// https://www.youtube.com/watch?v=GTJr8OvyEVQ
// https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java

public class KMP {
    static int[] a; //lps

    public static void main(String[] args) {
//        String s = "abcdabca";
//        String s = "aabaabaaa";
        System.out.println('b'-'a');
        String text = "abcxzabyabcxabyabyabyx";
        String pattern = "abyaby";
        pattern.contains("n");
        int pn = pattern.length();
        a = new int[pn];
        long t = (long) 1e6;
        fillLPSArray(pattern.toCharArray(), pn);
        System.out.println(Arrays.toString(a));
        System.out.println(KMPOccurances(text.toCharArray(), pattern.toCharArray()));
    }

    private static void fillLPSArray(char[] s, int n) {
        a[0] = 0;
        int i = 1, j = 0;
        while (i < n) {
            if (s[i] != s[j]) {
                if (j != 0) {
                    j = a[j - 1];
                } else {
                    a[i] = 0;
                    i++;
                }
            } else {
                a[i] = j + 1;
                i++;
                j++;
            }
        }
    }

    static public int KMPOccurances(char[] text , char[] pattern) { // find number of occurrences of pattern in text
        int ti = 0;
        int pi = 0;
        int count = 0;
        while (ti < text.length) {
            if (text[ti] == pattern[pi]) {
                if (pi == pattern.length - 1) {
                    count++;
                    pi = a[pi - 1];
                } else {
                    ti++;
                    pi++;
                }
            } else {
                if (pi != 0) {
                    pi = a[pi - 1];
                } else {
                    ti++;
                }
            }
        }
        return count;
    }

    // Chech text contains the pattern or not - check for the first instance
    public boolean KMP(char []text, char []pattern){

        int i=0;
        int j=0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = a[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }



}
