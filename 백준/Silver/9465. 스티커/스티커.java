
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t,n;
		int[][] arr;
		int[][] dp;
		t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[2][n];
			dp = new int[2][n];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[0][j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[1][j] = Integer.parseInt(st.nextToken());
			}
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			int max, answer=0, curMax=0;
			answer = Math.max(dp[0][0], dp[1][0]);
			for(int j=1; j<n; j++) {
				if(j>1) {
					curMax = Math.max(dp[0][j-2], dp[1][j-2]);	
				}
				max = Math.max(curMax, dp[1][j-1]);
				dp[0][j] = max+arr[0][j];
				
				max = Math.max(curMax, dp[0][j-1]);
				dp[1][j] = max+arr[1][j];
				answer = Math.max(answer, Math.max(dp[0][j], dp[1][j]));
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
