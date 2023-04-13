package hackerearth.math.numbertheory.primetest.easy;

import java.util.*;

class PP {
    static int N = 100;
    static int isPrime[] = new int[N];
    static int cumSieve[] = new int[N];
    static int isPP[] = new int[N];
    static int cumPP[] = new int[N];
    public static void main(String args[] ) throws Exception {

        sieve();
        cumsieve();
        makePP();
        cumpp();
        for(int i=0; i<N; i++){
            System.out.println(i + "-> " + isPrime[i] + cumSieve[i] + isPP[i] + cumPP[i]);
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + " to " + b);
            System.out.println(cumPP[b] - cumPP[a] + isPP[a]);
        }
    }
    static void sieve() {
        for (int i=0; i<N; i++) {
            isPrime[i] = 1;
        }
        isPrime[0] = 0;
        isPrime[1] = 0;
        isPrime[2] = 1;
        isPrime[3] = 1;
        for (int i=4; i<N; i+=2) {
            isPrime[i] = 0;
        }
        for (int i=6; i<N; i+=3) {
            isPrime[i] = 0;
        }
        for (int i=5; i<N; i+=2) {
            if(isPrime[i] == 1) {
                for (long j = (long) i *i; j<N; j+=i) {
                    isPrime[(int)j] = 0;
                }
            }
        }
    }
    static void cumsieve() {
        cumSieve[0] = 0;
        for (int i=1; i<N; i++) {
            cumSieve[i] = cumSieve[i-1] + isPrime[i];
        }
    }
    static void makePP() {
        for (int i=0; i<N; i++) {
            isPP[i] = isPrime[cumSieve[i]];
        }
    }
    static void cumpp() {
        cumPP[0] = 0;
        for (int i=1; i<N; i++) {
            cumPP[i] = cumPP[i-1] + isPP[i];
        }
    }

}
