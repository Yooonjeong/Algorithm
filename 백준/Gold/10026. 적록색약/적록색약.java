
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static int n;
	public static char[][] arr;
	public static char[][] arr2;
	public static boolean[][] visited;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};
	public static LinkedList<Integer> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		queue = new LinkedList<>();
		arr = new char[n][n];
		arr2 = new char[n][n];
		visited = new boolean[n][n];
		
		String in;
		for(int i=0; i<n; i++) {
			in = br.readLine();
			for(int j=0; j<n; j++) {
				char at = in.charAt(j);
				arr[i][j] = at;
				if(at=='G') {
					arr2[i][j] = 'R';
				}
				else {
					arr2[i][j] = at;
				}
			}
		}
		int a=0, b=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					a++;
				}
			}
		}
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					dfs2(i,j);
					b++;
				}
			}
		}
		System.out.println(a+" "+b);
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
			if(range(curY,curX)&&!visited[curY][curX]&&arr[curY][curX]==arr[y][x]) {
				dfs(curY,curX);
			}
		}
	}
	public static void dfs2(int y, int x) {
		visited[y][x] = true;
		for(int i=0; i<4; i++) {
			int curX = x+dirX[i];
			int curY = y+dirY[i];
			if(range(curY,curX)&&!visited[curY][curX]&&arr2[curY][curX]==arr2[y][x]) {
				dfs2(curY,curX);
			}
		}
	}
}
