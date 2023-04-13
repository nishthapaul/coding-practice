package hackerearth.algo.string.manipulation.medium;

public class SwappingGame {

    public static void main(String[] args) {
        int k = 1; // number of swaps
        String s = "ctosnet"; // resultant string after k swaps
        String original = getOriginalString(s, k);
        System.out.println(original);
    }

    public static String getOriginalString(String s, long k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        char[] originalChars = new char[n];

        // Initialize originalChars with the given string


        // Convert the originalChars array to a string and return it
        return new String(originalChars);
    }
}
// Ye nahi ho raha merese