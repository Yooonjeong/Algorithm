
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[][] dp = new int[n][2];
		int ans = 1, ansI = 0;
		List<Integer> rst = new ArrayList<>();
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i][0] = 1;
			dp[i][1] = -1;
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i]) {
					if(dp[i][0] < dp[j][0]+1) {
						dp[i][0] = dp[j][0]+1;
						dp[i][1] = j;
					}
				}
				if(ans<dp[i][0]) {
					ans = dp[i][0];
					ansI = i;
				}
			}
		}
		while(ansI != -1) {
			rst.add(arr[ansI]);
			ansI = dp[ansI][1];
		}
		System.out.println(ans);
		StringBuilder sb = new StringBuilder();
		for(int i=rst.size()-1; i>=0; i--) {
			sb.append(rst.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}

}
