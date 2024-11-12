import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Java_formality_test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        BigInteger n = new BigInteger(input);
        System.out.println(n.isProbablePrime(5) ? "prime" : "not prime");
        bufferedReader.close();
    }
}
