import java.util.*;
import java.util.regex.*;

public class Tag_content_extractor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases-- > 0) {
            String line = in.nextLine();
            int flag = 0;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = r.matcher(line);
            while (m.find()) {
                System.out.println(m.group(2));
                flag = 1;
            }
            if (flag == 0) {
                System.out.println("None");
            }
        }
    }
}
