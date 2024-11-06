import java.util.Scanner;

public class Java_String_Introduction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        System.out.println(A.length() + B.length());
        System.out.println(A.compareToIgnoreCase(B) > 0 ? "Yes" : "No");

        String first = A.substring(0, 1).toUpperCase() + A.substring(1).toLowerCase();
        String second = B.substring(0, 1).toUpperCase() + B.substring(1).toLowerCase();
        System.out.println(first + " " + second);

        sc.close();
    }
}
