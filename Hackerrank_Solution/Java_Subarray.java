import java.util.Scanner;

public class Java_Subarray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count=0;

        int[] a = new int[n];
        for (int k=0;k<n;k++)
        {
            a[k]= scan.nextInt();
        }

        for (int i=0;i<n;i++)
        {
          int sum=0;
          for (int j =i; j<n;j++)
          {
              sum = sum+a[j];
              if (sum<0)
              count++;
          }
        }
        System.out.println(count);
    }
}
