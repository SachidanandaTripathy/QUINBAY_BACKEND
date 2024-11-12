import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Java_ArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<List<Integer>> al1 = new ArrayList<List<Integer>>();
        int n = sc.nextInt();
        while(n-->0) {
            ArrayList<Integer> al2 = new ArrayList<Integer>();
            int k = sc.nextInt();
            while(k-->0){
                al2.add(sc.nextInt());
            }
            al1.add(al2);
        }

        int q = sc.nextInt();
        while(q-->0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (y > al1.get(x - 1).size()) {
                System.out.println("ERROR!");
            } else {
                System.out.println(al1.get(x - 1).get(y - 1));
            }
        }
    }
}
