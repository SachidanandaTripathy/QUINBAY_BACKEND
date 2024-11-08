package Backend_Tasks;
import java.util.*;

class DigitException extends Exception {
    public DigitException(String message) {
        super(message);
    }
}

public class Custom_Exception {
    public static void checkNumber(int number) throws DigitException {
        if (number > 9 || number < -9) {
            throw new DigitException("The number has more than one digit.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt(); 
        
        try {
            checkNumber(number);
            System.out.println("The number has only one digit.");
        } catch (DigitException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            scanner.close(); 
        }
    }
}
