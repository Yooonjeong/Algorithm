
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n,m,k;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};
	public static int maxCnt=0, cnt=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		int x,y;
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			arr[y-1][x-1]=1;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(range(i, j)&&!visited[i][j]&&arr[i][j]==1) {
					cnt=0;
					dfs(i,j);
					maxCnt = Math.max(maxCnt, cnt);
				}
			}
		}
		System.out.println(maxCnt);
		
	}
	public static boolean range(int y, int x) {
		if(y>=0&&y<n&&x>=0&&x<m) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void dfs(int y, int x) {
		visited[y][x]=true;
		for(int i=0; i<4; i++) {
			int curX = x+dirX[i];
			int curY = y+dirY[i];
			if(range(curY, curX)&&!visited[curY][curX]&&arr[curY][curX]==1) {
				dfs(curY,curX);
			}
		}
		cnt++;
	}
}
