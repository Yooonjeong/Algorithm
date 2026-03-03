import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String t = br.readLine();

        StringBuilder sb = new StringBuilder(t);

        while (sb.length() > s.length()) {
            String last = sb.substring(sb.length()-1, sb.length());

            sb.setLength(sb.length()-1);
            if (last.equals("B")) {
                sb.reverse();
            }
        }

        System.out.println(s.equals(sb.toString()) ? "1" : "0");
    }
}