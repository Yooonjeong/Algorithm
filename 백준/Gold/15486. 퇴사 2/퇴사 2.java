import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n+1];
        int[] p = new int[n+1];
        long[] dp = new long[n+2];
        long max = 0;

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=n; i++) {
            if (dp[i]>max) {
                max = dp[i];
            }

            int endDay = i+t[i];
            
            if (endDay <= n+1) {
                dp[endDay] = Math.max(dp[endDay], max+p[i]);
            }
        }
        max = Math.max(max, dp[n+1]);
        System.out.println(max);
    }
}
