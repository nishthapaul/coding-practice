package hackerearth.math.numbertheory.primetest.easy;

import java.io.BufferedReader;
        import java.io.InputStreamReader;

class Shotout_london {
    static int N = 1000001;
    static boolean isPrime[] = new boolean[N];
    public static void main(String args[] ) throws Exception {
        sieve();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String strArray[] = br.readLine().trim().split(" ");
        int A[] = new int[strArray.length];
        for(int i=0; i<strArray.length; i++) {
            A[i] = Integer.parseInt(strArray[i]);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<strArray.length; i++) {
            if(isPrime[A[i]]) {
                sb.append(i+1 + " ");
            } else {
                for(int left = i-1, right = i+1; left>-1 || right<strArray.length; left--, right++) {
                    if(left>-1) {
                        if(isPrime[A[left]]) {
                            sb.append(left+1 + " ");
                            break;
                        }
                    }
                    if(right<strArray.length) {
                        if(isPrime[A[right]]) {
                            sb.append(right+1 + " ");
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
    static void sieve() {
        for (int i=0; i<N; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        isPrime[2] = true;
        isPrime[3] = true;
        for (int i=4; i<N; i+=2) {
            isPrime[i] = false;
        }
        for (int i=6; i<N; i+=3) {
            isPrime[i] = false;
        }
        for (int i=5; i<N; i+=2) {
            if(isPrime[i]) {
                for (long j = (long) i *i; j<N; j+=i) {
                    isPrime[(int)j] = false;
                }
            }
        }
    }
}
