import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int BASE = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        if (n == 0 || n == 1) {
            sb.append(n).append("\n").append(n);
            System.out.println(sb.toString());
            return;
        }

        int absN = Math.abs(n);
        int[] dp = new int[absN+1];
        dp[1] = 1;
        
        if (n > 1) {
            dp[1] = 1;
            for (int i=2; i<=n; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % BASE;
            }
            sb.append(1).append("\n").append(dp[n]);
        }
        else {
            dp[1] = 1;
            for (int i=-2; i>=n; i--) {
                dp[-i] = (dp[-(i+2)] - dp[-(i+1)]) % BASE;
            }
            int flag = (dp[absN] == 0) ? 0 : (dp[absN] > 0) ? 1 : -1;
            sb.append(flag).append("\n").append(flag*dp[absN]);
        }
        System.out.println(sb.toString());
    }
}
