
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static int n, d;
	public static ArrayList<int[]> path;
	public static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		path = new ArrayList<>();
		dp = new int[d+1];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			if(end>d) { continue; }
			if(end-start<=dist) { continue; }
			path.add(new int[] {start, end, dist});
		}
		Collections.sort(path, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return Integer.compare(o1[1],o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
			
		});
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int idx = 0, move = 0;
		while(move<d) {
			if(idx<path.size()) {
				int cur[] = path.get(idx);
				if(move==cur[0]) {
					dp[cur[1]] = Math.min(dp[move]+cur[2], dp[cur[1]]);
					idx++;
				}
				else {
					dp[move+1] = Math.min(dp[move+1], dp[move]+1);
					move++;
				}
			}
			else {
				dp[move+1] = Math.min(dp[move+1], dp[move]+1);
				move++;
			}
		}
		System.out.println(dp[d]);
		

	}


}
