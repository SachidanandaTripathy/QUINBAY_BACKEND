import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Java_List {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> al = new ArrayList<Integer>();
        while (n-- > 0) {
            al.add(sc.nextInt());
        }
        int q = sc.nextInt();

        while (q-- > 0) {
            String op = sc.next();
            if (op.equals("Insert")) {
                int index = sc.nextInt();
                int value = sc.nextInt();
                al.add(index, value);
            } else if (op.equals("Delete")) {
                int index = sc.nextInt();
                al.remove(index);
            }
        }
        for (int el : al) {
            System.out.print(el + " ");
        }
    }
}
