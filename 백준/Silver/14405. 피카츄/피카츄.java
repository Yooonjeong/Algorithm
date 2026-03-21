import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();
        int len = in.length();

        for (int i=0; i<in.length(); i++) {
            if (in.substring(i, Math.min(i+2, len)).equals("pi") ||
                in.substring(i, Math.min(i+2, len)).equals("ka")) {
                i++;        
            }
            else if (in.substring(i, Math.min(i+3, len)).equals("chu")) {
                i+=2;
            }
            else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}