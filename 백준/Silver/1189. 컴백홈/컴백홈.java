
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static int r,c,k;
	public static char[][] arr;
	public static boolean[][] visited;
	public static Deque<int[]> q;
	public static int[] dirX = {0,1,0,-1};
	public static int[] dirY = {-1,0,1,0};
	public static int answer=0;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		visited = new boolean[r][c];
		q = new ArrayDeque<>();
		for(int i=0; i<r; i++) {
			String in = br.readLine();
			for(int j=0; j<c; j++) {
				arr[i][j] = in.charAt(j);
			}
		}
		visited[r-1][0] = true;
		dfs(r-1,0,1);
		System.out.println(answer);
	}
	
	public static boolean range(int y, int x) {
		if(y>=0&&y<r&&x>=0&&x<c) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void dfs(int y, int x, int depth) {
		if(y==0&&x==c-1) {
			if(depth==k) {
				answer++;
			}
			return;
		}
		for(int i=0; i<4; i++) {
			int curY = y+dirY[i];
			int curX = x+dirX[i];
			if(range(curY,curX)&&arr[curY][curX]!='T'&&!visited[curY][curX]) {
				visited[curY][curX] = true;
				dfs(curY,curX,depth+1);
				visited[curY][curX] = false;
			}
		}
	}

}
