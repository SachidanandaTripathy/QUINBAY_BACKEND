import java.util.Scanner;

public class Java_If_Else {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        if ((n % 2 == 1) || (n >= 6 && n <= 20)) {
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }

    }
}
