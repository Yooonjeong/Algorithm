
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int n, r1,c1,r2,c2;
	public static boolean[][] visited;
	public static int[][] dp;
	public static int[] dirY = {-2,-2,0,0,2,2};
	public static int[] dirX = {-1,1,-2,2,-1,1};
	public static Deque<int[]> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n][n];
		dp = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], 1000);
		}
		q = new ArrayDeque<>();
		bfs();
		if(dp[r2][c2]==1000&&!visited[r2][c2]) {
			System.out.println("-1");
		}
		else {
			System.out.println(dp[r2][c2]);	
		}
	}
	public static boolean range(int y, int x) {
		if(y>=0&&y<n&&x>=0&&x<n) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void bfs() {
		q.offerLast(new int[] {r1,c1,0});
		visited[r1][c1] = true;
		while(!q.isEmpty()) {
			int cur[] = q.pollFirst();
			dp[cur[0]][cur[1]] = Math.min(dp[cur[0]][cur[1]], cur[2]);
			for(int i=0; i<6; i++) {
				int curY = cur[0]+dirY[i];
				int curX = cur[1]+dirX[i];
				if(range(curY,curX)&&!visited[curY][curX]) {
					q.offerLast(new int[] {curY,curX,cur[2]+1});
					visited[curY][curX] = true;
				}
			}
		}
	}
}
