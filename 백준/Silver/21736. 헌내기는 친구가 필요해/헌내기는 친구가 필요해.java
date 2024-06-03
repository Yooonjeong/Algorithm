
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n,m;
	public static char[][] arr;
	public static boolean[][] visited;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};
	public static int cnt=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		visited = new boolean[n][m];
		
		int x=0,y=0;
		for(int i=0; i<n; i++) {
			String in = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = in.charAt(j);
				if(arr[i][j]=='I') {
					y = i;
					x = j;
				}
			}
		}
		dfs(y,x);
		if(cnt==0) {
			System.out.println("TT");
		}
		else {
			System.out.println(cnt);	
		}
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
		if(arr[y][x]=='P') {
			cnt++;
		}
		for(int i=0; i<4; i++) {
			int curX = x+dirX[i];
			int curY = y+dirY[i];
			if(range(curY,curX)&&!visited[curY][curX]&&arr[curY][curX]!='X') {
				dfs(curY,curX);
			}
		}
	}

}
