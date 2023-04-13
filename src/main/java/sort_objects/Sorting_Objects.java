package sort_objects;

import java.util.*;

public class Sorting_Objects {
    static class Pair {
        int x;
        String s;

        public Pair(String s, int x) {
            this.x = x;
            this.s = s;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", s='" + s + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        Pair[] parr = new Pair[5];
        parr[0] = new Pair("cfg", 4);
        parr[1] = new Pair("abz", 4);
        parr[2] = new Pair("abc", 4);
        parr[3] = new Pair("abc", 7);
        parr[4] = new Pair("abc", 2);
        final String substring = parr[4].s.substring(0, 8);
        // In p1-p2 -> negative = asc, p1<p2 ; positive = desc p1>p2
        Comparator<Pair> comparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if(p1.x == p2.x) {
                    return p1.s.compareTo(p2.s);
                } else {
                    return p1.x - p2.x;
                }
            }
        };
        Arrays.sort(parr, comparator);
        System.out.println(Arrays.toString(parr));
        List<Pair> l = new ArrayList<>();
        l.sort(comparator);

//        map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
    }
}
/*
eklpyqrbgjdwtcaxzsnifvhmou
abcdefghijklmnopqrstuvwxyz

 */