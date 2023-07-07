package coding_ninja.problem_of_the_day;

import java.util.*;
public class Jun13_2023_Medium {

    public static void main(String[] args) {
//        totalStrings("babbbcbccb");
        totalStrings("aabc");
    }

    public static int totalStrings(String s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 3;
        }
        int ans = 0;
        int currFreq = 1;
        Map<Character, Integer> map = new HashMap<>();
        int prevBagage = 0;
        map.put(s.charAt(0), 1);
        printMap(map);
        for (int i=1; i<n; i++) {
            System.out.println("i = " + i + " char = " + s.charAt(i));
            if (s.charAt(i) == s.charAt(i-1)) {
                currFreq++;
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                printMap(map);
            } else {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                printMap(map);
                if(map.size() > 2) {
                    char charToBeRemoved = getThirdChar(map, s.charAt(i), s.charAt(i-1));
                    System.out.println("charToBeRemoved = " + charToBeRemoved);
                    int totalCharsTillNow = map.get(charToBeRemoved) + map.get(s.charAt(i-1));
                    System.out.println("totalCharsTillNow = " + totalCharsTillNow);
                    int sumTillNow = ( totalCharsTillNow * (totalCharsTillNow+1) )/2;
                    System.out.println("sumTillNow = " + sumTillNow);
                    int baggageToBeAdded = prevBagage * totalCharsTillNow;
                    System.out.println("prev baggage which will be added with sum now = " + baggageToBeAdded);
                    ans += baggageToBeAdded + sumTillNow;
                    System.out.println("ans = " + ans);
                    prevBagage = currFreq;
                    System.out.println("prev baggage to be multiplied later = " + prevBagage);
                    map.put(s.charAt(i-1), 0);
                    map.remove(charToBeRemoved);
                    printMap(map);
                }
                currFreq = 1;
            }
        }
        int totalCharsTillNow = sumMap(map);
        System.out.println("totalCharsTillNow = " + totalCharsTillNow);
        int sumTillNow = ( totalCharsTillNow * (totalCharsTillNow+1) )/2;
        System.out.println("sumTillNow = " + sumTillNow);
        int baggageToBeAdded = prevBagage * totalCharsTillNow;
        System.out.println("prev baggage which will be added with sum now = " + baggageToBeAdded);
        ans += baggageToBeAdded + sumTillNow;
        System.out.println("ans = " + ans);
        prevBagage = currFreq;
        System.out.println("prev baggage to be multiplied later = " + prevBagage);
        return ans;
    }
    public static char getThirdChar(Map<Character, Integer> map, char ch1, char ch2) {
        for (char ch : map.keySet()) {
            if (ch != ch1 && ch != ch2) {
                return ch;
            }
        }
        return ch1;
    }
    public static void printMap(Map<Character, Integer> map) {
        System.out.print("Map = ");
        for (char ch : map.keySet()) {
            System.out.print(ch + " : " + map.get(ch) + " , ");
        }
        System.out.print("\n");
    }
    public static int sumMap(Map<Character, Integer> map) {
        int sum = 0;
        for (char ch : map.keySet()) {
            sum += map.get(ch);
        }
        return sum;
    }
}