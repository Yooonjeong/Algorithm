import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int percent;
        
        if (n >= 1000000) {
            percent = 20;
        } else if (n >= 500000) {
            percent = 15;
        } else if (n >= 100000) {
            percent = 10;
        } else {
            percent = 5;
        }
        
        int give = n * percent / 100;
        int remain = n - give;
        
        System.out.println(give + " " + remain);
    }
}