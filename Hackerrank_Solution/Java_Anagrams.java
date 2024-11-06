import java.util.Scanner;

public class Java_Anagrams {
    static boolean isAnagram(String a, String b) {
        if(a.length()!=b.length()){
            return false;
        }
        int ch[]=new int[26];
        a=a.toLowerCase();
        b=b.toLowerCase();
        for(int i=0;i<a.length();i++){
            char cha=a.charAt(i);
            ch[cha-'a']++;
        }
        for(int i=0;i<b.length();i++){
            char cha=b.charAt(i);
            ch[cha-'a']--;
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i]!=0){
                return false;
            }
        }
        return true;
    }

      public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
