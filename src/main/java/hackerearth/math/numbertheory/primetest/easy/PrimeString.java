package hackerearth.math.numbertheory.primetest.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/primestring/
public class PrimeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            System.out.println(s);
            Map<Character, Integer> map = new HashMap<>();
            for (Character ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            Set<Character> keys = map.keySet();
            if (!isPrime(keys.size())) {
                System.out.println("NO");
                continue;
            }
            boolean flag = true;
            for (Character ch : keys) {
                if (!isPrime(map.get(ch))) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }

    static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

/*
Input
3
ababb
abcab
aabbccdd

Output
YES
NO
NO
 */