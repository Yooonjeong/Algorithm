
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		String a, b;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b = br.readLine();
		int n = a.length(), m = b.length();
		
		int[][] dp = new int[a.length()+1][b.length()+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[n][m]);
	}

}
