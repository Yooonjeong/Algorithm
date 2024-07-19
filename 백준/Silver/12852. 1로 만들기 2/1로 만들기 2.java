
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n+1];
	    int before[] = new int[n+1];
	    String ans = "";
	    for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            before[i] = i - 1;
 
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                before[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                before[i] = i / 2;
            }
        }
	    StringBuilder sb = new StringBuilder();
	    sb.append(dp[n]).append("\n");
	    while(n>0) {
	    	ans+=n+" ";
	    	n = before[n];
	    }
	    sb.append(ans);
	    System.out.println(sb.toString());
	}

}
