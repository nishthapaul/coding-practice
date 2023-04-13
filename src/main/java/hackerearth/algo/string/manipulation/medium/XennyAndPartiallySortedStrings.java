package hackerearth.algo.string.manipulation.medium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class XennyAndPartiallySortedStrings {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int m = Integer.parseInt(str[2]);
            Pair[] arr = new Pair[n];
            for (int i = 0; i < n; i++) {
                String word = br.readLine();
                Pair p = new Pair(word, word.substring(0, m));
                arr[i] = p;
            }
            Comparator<Pair> comp = new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return p1.sub.compareTo(p2.sub);
                }
            };
            Arrays.sort(arr, comp);
            System.out.println(Arrays.toString(arr));
            result.append(arr[k-1].s + "\n");
        }
        System.out.println(result);
    }

    static class Pair {
        String s;
        String sub;

        Pair(String s, String sub) {
            this.s = s;
            this.sub = sub;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "s='" + s + '\'' +
                    ", sub='" + sub + '\'' +
                    '}';
        }
    }
}
