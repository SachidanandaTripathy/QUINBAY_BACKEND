import java.util.*;

class Operation {
    public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int n) {
        String original = Integer.toString(n);
        String reversed = new StringBuilder(original).reverse().toString();
        return original.equals(reversed);
    }
}
public class Java_Lambda_Expression {
    public static void main(String[] args) {
        Operation ob = new Operation();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String ans;
        
        while (T-- > 0) {
            int ch = sc.nextInt();
            int num = sc.nextInt();
            if (ch == 1) {
                ans = ob.isOdd(num) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                ans = ob.isPrime(num) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                ans = ob.isPalindrome(num) ? "PALINDROME" : "NOT PALINDROME";
            } else {
                ans = "INVALID OPERATION";
            }
            System.out.println(ans);
        }
    }
}
