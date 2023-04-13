package hackerearth.algo.string.manipulation.medium;

public class PrintAllSubstrings {
    public static void main(String[] args) {
        String s = "babac";
        int n = s.length();
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=i; j<n; j++) {
                sb.append(s.charAt(j));
                System.out.println(sb);
            }
            System.out.print("\n");
        }
    }
}
