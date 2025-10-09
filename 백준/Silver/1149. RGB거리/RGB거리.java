import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][3];

        StringTokenizer st;

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                dp[i][j] = findMin(i, j) + Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
    private static int findMin(int y, int x) {
        switch (x) {
            case 0: return Math.min(dp[y-1][1], dp[y-1][2]);
            case 1: return Math.min(dp[y-1][0], dp[y-1][2]);
            case 2: return Math.min(dp[y-1][0], dp[y-1][1]);
            default: return 0;
        }
    }
}
