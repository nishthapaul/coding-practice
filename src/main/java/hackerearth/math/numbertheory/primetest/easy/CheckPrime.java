package hackerearth.math.numbertheory.primetest.easy;

import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Take long for big inputs
public class CheckPrime {
    static int N = 100;
    static int isPrime[] = new int[N];
    public static void main(String[] args) throws IOException {
        sieve();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            System.out.println("isPrime[" + i + "] - " + isPrime[i]);
        }
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String ans = withoutSieveIterative(n)? "prime" : "composite";
            System.out.println(ans);
        }
    }
    static boolean withoutSieveIterative (int n) {
        if(n==0 || n==1) {return false;}
        if(n==2 || n==3) {return true;}
        if(n%2 == 0 || n%3 == 0) {return false;}
        for(int i=5; i*i<=n; i++) {
            if(n%i == 0) {return false;}
        }
        return true;
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
}

