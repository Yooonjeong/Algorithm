
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};
	public static int m, n, k;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int x, y;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			visited = new boolean[n][m];
			for(int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				arr[y][x] = 1;
			}
			int cnt=0;
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(!visited[j][k]&&arr[j][k]==1) {
						dfs(j, k);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static boolean range(int y, int x) {
		if(x>=0&&x<m&&y>=0&&y<n) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		int curX, curY;
		for(int i=0; i<4; i++) {
			curX = x+dirX[i];
			curY = y+dirY[i];
			if(range(curY, curX)&&!visited[curY][curX]&&arr[curY][curX]==1) {
				dfs(curY, curX);
			}
		}
	}

}
