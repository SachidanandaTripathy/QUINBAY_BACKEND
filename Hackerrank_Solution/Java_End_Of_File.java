import java.util.Scanner;

public class Java_End_Of_File {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int cnt=1;
        while(sc.hasNext()){
            String str=sc.nextLine();
            System.out.println(cnt+" "+str);
            cnt++;
        }
    }
}
