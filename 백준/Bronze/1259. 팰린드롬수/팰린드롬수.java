import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in;
        StringBuilder sb = new StringBuilder();
        while (true) {
            in = br.readLine();
            if (in.equals("0")) break;
            boolean isPelen = true;
            for (int i=0; i<in.length()/2; i++) {
                if (in.charAt(i) != in.charAt(in.length()-1-i)) {
                    sb.append("no").append("\n");
                    isPelen = false;
                    break;
                }
            }
            if (isPelen) {
                sb.append("yes").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
