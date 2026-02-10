import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            list.add(br.readLine());
        }

        int maxLen = 0;
        String a = "";
        String b = "";

        for (int i=0; i<n-1; i++) {
            String c = list.get(i);
            if (c.length() <= maxLen) continue;

            for (int j=i+1; j<n; j++) {
                String d = list.get(j);
                if (d.length() <= maxLen) continue;
                
                int len = getPrefixLen(c, d);
                if (len > maxLen) {
                    maxLen = len;
                    a = c;
                    b = d;
                }
            }
        }

        if (maxLen == 0) {
            System.out.println(list.get(0)+"\n"+list.get(1));
        } else {
            System.out.println(a+"\n"+b);
        }
    }
    
    private static int getPrefixLen(String a, String b) {
        int minLen = Math.min(a.length(), b.length());
        
        int len = 0;
        for (int i=0; i<minLen; i++) {
            if (a.charAt(i) != b.charAt(i)) break;
            len++;
        }

        return len;
    }
}