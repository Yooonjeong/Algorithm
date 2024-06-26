
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		long[][] dp = new long[n][n];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = arr[0][0];
		for(int i=1; i<n; i++) {
			dp[i][0] = dp[i-1][0]+arr[i][0];
			for(int j=1; j<i; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+arr[i][j];
			}
			dp[i][i] = dp[i-1][i-1]+arr[i][i];
		}
		Arrays.sort(dp[n-1]);
		System.out.println(dp[n-1][n-1]);
	}

}
