
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static char arr[][];
	public static boolean visited[][];
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new char[m][n];
		visited = new boolean[m][n];
		for(int i=0; i<m; i++) {
			String in = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = in.charAt(j);
			}
		}
		for(int i=0; i<n; i++) {
			if(arr[0][i]=='0') {
				dfs(0,i);
			}
		}
		boolean check=false;
		for(int i=0; i<n; i++) {
			if(visited[m-1][i]==true) {
				check = true;
			}
		}
		if(check) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
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
		for(int i=0; i<4; i++) {
			int curX = x+dirX[i];
			int curY = y+dirY[i];
			if(range(curY,curX)&&!visited[curY][curX]&&arr[curY][curX]=='0') {
				dfs(curY,curX);
			}
		}
	}
}
