import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
   public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int ans = (n + 4) / 5;
        System.out.println(ans);
    }
}
