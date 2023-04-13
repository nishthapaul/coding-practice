package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO_BufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read one number -> "9"
        int t = Integer.parseInt(br.readLine());

        // Read 2 numbers on one line -> "2 3"
        String[] nm = br.readLine().trim().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);


        // string to characters array
        String s = "ABCD";
        char[] charArray = s.toCharArray();

        // string to integers array
        String str = "1 2 3 4 5";
        String strArray[] = str.split(" ");
        int intArray[] = new int[strArray.length];
        for(int i=0; i< strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

    }

}
