import java.util.Scanner;
import java.util.Stack;

public class Java_stack {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                } else {
                    char c = stack.peek();
                    if ((c == '(' && ch == ')') || 
                        (c == '{' && ch == '}') || 
                        (c == '[' && ch == ']')) {
                        stack.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                }
            }
            
            if (!stack.isEmpty()) {
                isBalanced = false;
            }

            System.out.println(isBalanced);
        }
        
        sc.close();
    }
}
