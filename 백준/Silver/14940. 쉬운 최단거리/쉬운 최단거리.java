
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int n,m,x,y;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[][] dp;
	public static Deque<int[]> q;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		dp = new int[n][m];
		q = new ArrayDeque<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					x = j;
					y = i;
					dp[i][j] = -1;
				}
				else if(arr[i][j]==0) {
					dp[i][j] = 0;
				}
				else {
					dp[i][j] = -1;
				}
			}
		}
		bfs();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sb.append(dp[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	public static boolean range(int y, int x) {
		if(y>=0&&y<n&&x>=0&&x<m) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void bfs() {
		visited[y][x] = true;
		q.offerLast(new int[] {y,x,0});
		while(!q.isEmpty()) {
			int cur[] = q.pollFirst();
			dp[cur[0]][cur[1]] = cur[2];
			for(int i=0; i<4; i++) {
				int curY = cur[0]+dirY[i];
				int curX = cur[1]+dirX[i];
				if(range(curY,curX)&&!visited[curY][curX]&&arr[curY][curX]==1) {
					visited[curY][curX] = true;
					q.offerLast(new int[] {curY,curX,cur[2]+1});
				}
			}
		}
	}
}
