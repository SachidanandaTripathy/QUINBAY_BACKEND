import java.util.*;
import java.math.*;
public class Java_BigInteger {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BigInteger one=new BigInteger(sc.next());
        BigInteger two=new BigInteger(sc.next());
        System.out.println(one.add(two));
        System.out.println(one.multiply(two));
    }
}

