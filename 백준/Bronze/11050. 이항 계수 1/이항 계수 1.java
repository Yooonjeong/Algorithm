
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		int n, k;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int dp[][] = new int[11][11];
		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;
		for(int i=2; i<=10; i++) {
			dp[i][0] = 1;
			for(int j=1; j<i; j++) {
				dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
			}
			dp[i][i] = 1;
		}
		System.out.println(dp[n][k]);
		
	}

}
