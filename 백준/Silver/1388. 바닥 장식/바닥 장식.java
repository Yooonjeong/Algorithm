
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n,m;
	public static char[][] arr;
	public static boolean[][] visited;
	public static int[] dir = {-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String in = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = in.charAt(j);
			}
		}
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
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
		visited[y][x] = true;
		char at = arr[y][x];
		if(at=='-') {
			for(int i=0; i<2; i++) {
				int curX = x+dir[i];
				if(range(y,curX)&&!visited[y][curX]&&arr[y][curX]==at) {
					dfs(y, curX);
				}
			}	
		}
		else if(at=='|') {
			for(int i=0; i<2; i++) {
				int curY = y+dir[i];
				if(range(curY,x)&&!visited[curY][x]&&arr[curY][x]==at) {
					dfs(curY, x);
				}
			}
		}
	}

}
