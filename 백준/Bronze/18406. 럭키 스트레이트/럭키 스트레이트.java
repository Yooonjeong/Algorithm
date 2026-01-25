import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();

        int fst = 0, sec = 0;
        int n = in.length();

        for (int i=0; i<n/2; i++) {
            fst += in.charAt(i) - '0';
        }
        
        for (int i=n/2; i<n; i++) {
            sec += in.charAt(i) - '0';
        }

        if (fst == sec) {
            System.out.println("LUCKY");
        }
        else {
            System.out.println("READY");
        }
    }
}
