import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String pop = br.readLine();
        int len = pop.length();
        char last = pop.charAt(len-1);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<str.length(); i++) {
            char at = str.charAt(i);
            sb.append(at);

            if (sb.length() >= len && at == last) {
                if (sb.substring(sb.length()-len, sb.length()).equals(pop)) {
                    sb.delete(sb.length()-len, sb.length());
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}