package mala;

public class Q2 {
    public static void main(String[] args) {
        int m = 3;

        System.out.println(findRotatedNumber(m));
    }

    private static String findRotatedNumber(int m) {
        for (int counter = 1; counter <= 9; counter++) {
            System.out.println("........... counter = " + counter + " ....................");
            StringBuilder as = new StringBuilder();
            StringBuilder ps = new StringBuilder();
            int a = counter;
            int p = 0;
            int carry = 0;
            for (int i = 1; i < 50; i++) {
                int prod = a * m + carry;
                carry = prod / 10;
                p = prod % 10;
                System.out.print("a :: " + a + ", p :: " + p + ", carry :: " + carry + "\n");
                as.append(a);
                ps.append(p);
                if (a != 0 && carry == 0 && counter == p) {
                    System.out.println("carry == 0 && counter == p");
                    StringBuilder asCopy = new StringBuilder(as);
                    asCopy.reverse();
                    StringBuilder psCopy = new StringBuilder(ps);
                    psCopy.reverse();
                    if (checkRotation(asCopy, psCopy)) {
                        return asCopy.toString();
                    }
                }
                a = p;
            }
        }
        return "NOT FOUND";
    }

    private static boolean checkRotation(StringBuilder as, StringBuilder ps) {
        System.out.println("checking rotation on ");
        System.out.println("as - " + as);
        System.out.println("ps - " + ps);
        final String substringA = as.substring(0, as.length() - 1);
        final String substringP = ps.substring(1);
        System.out.println(substringA + " " + substringP);
        return substringA.equals(substringP);
    }

}

/*
 An n-right-circular number for 2 <= n <= 9 is a natural number such that, when
 multiplied by n, the decimal representation of the result is the same as for the
 original number, except with the rightmost digit moved to the front. In other words, the
 decimal representation undergoes a right circular shift by one place. Write a program to
 calculate the smallest n-right-circular number for given N. (You have to calculate the
 number and not just print it).
 Input:
 4
 Ouput:
 102564
 */