import java.util.*;
public class Java_String_Reverse {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int i=0,j=A.length()-1;
        boolean flag=true;
        while(i<=j){
            if(A.charAt(i)!=A.charAt(j)){
                flag=false;
                break;
            }
            i++;j--;
        }
        if(flag){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        
    }
}
