import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            
            int days = Integer.parseInt(s.substring(2)); 
            
            if (days <= 90) {
                count++;
            }
        }

        System.out.println(count);
    }
}