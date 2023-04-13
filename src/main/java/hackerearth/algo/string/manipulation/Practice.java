package hackerearth.algo.string.manipulation;

import java.util.HashSet;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {
        String str = "hello";
        Long l = new Long(1000000001);
        final Long root1 = (long) Math.sqrt(l);
        System.out.println(root1);
        char[] strArray = str.toCharArray();
        char[] strArray2 = {'k', 'l', '\0'};
        System.out.println(strArray2.length);
        strArray[0] = String.valueOf(9).charAt(0);
        System.out.println(strArray);
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder(str);
        Integer[] ip = new Integer[9];
        set.add('l');
        set.remove('j');
        final long v = (long) (Math.pow(10, 9) + 7);
    }

    String removeDuplicateCharacters(String s) { // OR USE SET/HASHSET
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch, i + 1) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
