import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] dp = new int[t+1][w+1];

        for (int i=1; i<=t; i++) {
            int tree = Integer.parseInt(br.readLine());

            for (int j=0; j<=w; j++) {
                int add = tree == (j%2 == 0 ? 1 : 2) ? 1 : 0;

                if (j==0) {
                    dp[i][j] = dp[i-1][j] + add;
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + add;
            }
        }

        int max = 0;
        for (int num : dp[t]) {
            max = Math.max(max, num);
        }

        System.out.println(max);
    }

}
