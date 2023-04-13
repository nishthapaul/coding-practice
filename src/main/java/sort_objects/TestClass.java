package sort_objects;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.math.BigInteger;
import java.util.*;

// Sort characters in a string on the basis of frequency of their characters
class TestClass {
    static class Pair{
        char ch;
        int f;
        Pair(char ch, int f) {
            this.ch = ch;
            this.f = f;
        }
    }
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (t-- > 0) {
            Map<Character, Integer> map = new HashMap<>();
            String str = br.readLine();
            int n = str.length();
            for (int i=0; i<n; i++) {
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            }

            List<Pair> pl = new ArrayList<>();
            for (Character key : map.keySet()) {
                Pair p = new Pair(key, map.get(key));
                pl.add(p);
            }
            Comparator<Pair> comparator = new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    if (p1.f == p2.f) {
                        return p1.ch - p2.ch;
                    } else {
                        return p1.f - p2.f;
                    }
                }
            };
            Collections.sort(pl, comparator);
            StringBuilder sb = new StringBuilder();
            for (Pair p : pl) {
                for (int i=0; i<p.f; i++) {
                    sb.append(p.ch);
                }
            }
            result.append(sb + "\n");
        }
        System.out.println(result);
    }
}
