package hackerearth.math.numbertheory.primetest.easy;

public class SmallestPrimeFactor {
    static int N = 1000;
    static int[] pf = new int[N];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            pf[i] = i;
        }
        makepfactor();
        for (int i = 0; i < N; i++) {
            System.out.println("pf[" + i + "]=" + pf[i]);
        }
    }

    static int getpfactor(int n) { // Not DP
        if (n % 2 == 0) {
            return 2;
        }
        if (n % 3 == 0) {
            return 3;
        }
        for (int i = 5; i * i <= n; i += 2) {
            if (n % i == 0) {
                return i;
            }
        }
        return n;
    }

    static void makepfactor() { // DP Approach
        for (int i = 2; i < N; i += 2) {
            pf[i] = 2;
        }
        for (int i = 3; i < N; i += 3) {
            pf[i] = 3;
        }
        for (int i = 5; i < N; i += 2) {
            if (pf[i] == i) {
                for (long j = (long) i * i; j < N; j += i) {
                    if (pf[(int) j] == j) {
                        pf[(int) j] = i;
                    }
                }
            }
        }
    }
}
