import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> coin = new ArrayList<>();
        int[] dp = new int[k+1];
        dp[0] = 1;

        for (int i=0; i<n; i++) {
            coin.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(coin);

        for (int c:coin) {
            for (int money = c; money<=k; money++) {
                dp[money] += dp[money-c];
            }
        }
        System.out.println(dp[k]);
    }
}
