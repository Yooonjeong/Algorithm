
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int[][] arr;
	public static int[] dirX = {-1,0,1,1,1,0,-1,-1};
	public static int[] dirY = {-1,-1,-1,0,1,1,1,0};
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		visited = new boolean[m][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]&&arr[i][j]==1) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	public static boolean range(int y, int x) {
		if(y>=0&&y<m&&x>=0&&x<n) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		for(int i=0; i<8; i++) {
			int curX = x+dirX[i];
			int curY = y+dirY[i];
			if(range(curY,curX)&&!visited[curY][curX]&&arr[curY][curX]==1) {
				dfs(curY,curX);
			}
		}
	}
}
