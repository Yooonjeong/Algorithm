
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a, b;
		a = br.readLine();
		b = br.readLine();
		int n = a.length(), m = b.length();
		int[][] dp = new int[n+1][m+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				if(i==0) {
					dp[i][j] = j;
					continue;
				}
				if(j==0) {
					dp[i][j] = i;
					continue;
				}
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
				}
			}
		}
		System.out.println(dp[n][m]);
	}

}
