
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int maxCnt=0, height, cnt;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		StringTokenizer st;
		int maxHeight=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>maxHeight) {
					maxHeight=arr[i][j];
				}
			}
		}
		for(height=0; height<=maxHeight; height++) {
			cnt=0;
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(range(i,j)&&arr[i][j]>height&&!visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
	}
	public static boolean range(int y, int x) {
		if(y>=0&&y<n&&x>=0&&x<n) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		for(int i=0; i<4; i++) {
			int curX = x+dirX[i];
			int curY = y+dirY[i];
			if(range(curY,curX)&&arr[curY][curX]>height&&!visited[curY][curX]) {
				dfs(curY,curX);
			}
		}
	}
}
