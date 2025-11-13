import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static long[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int cur = 1;
        long ans = 1;
        dp = new long[n+1];
        for (int i=0; i<m; i++) {
            int vip = Integer.parseInt(br.readLine());
            ans *= dp(vip-cur);
            cur = vip+1;
        }
        ans *= dp(n+1-cur);

        System.out.println(ans);
    }
    private static long dp(int i) {
        if (i == 0) return 1;
        if (i == 1 || i == 2) return i;
        if (dp[i] > 0) return dp[i];
        dp[i] = dp(i-1) + dp(i-2);
        return dp[i];
    }
}
