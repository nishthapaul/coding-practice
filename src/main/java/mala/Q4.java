package mala;

public class Q4 {
    public static void main(String[] args) {
        int input = 6;

        String result = getNextString(input);
        System.out.println("result :: " + result);
    }

    private static String getNextString(int input) {
        String result = "1";
        for (int i = 2; i <= input; i++) {
            StringBuilder sb = new StringBuilder();

            int c = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    c++;
                } else {
                    sb.append(c);
                    sb.append(result.charAt(j - 1));
                    c = 1;
                }
            }
            sb.append(c);
            sb.append(result.charAt(result.length() - 1));

            result = sb.toString();
            System.out.println(result);
        }
        return result;
    }

}
