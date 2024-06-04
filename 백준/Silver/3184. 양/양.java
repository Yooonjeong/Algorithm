
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int r,c;
	public static char[][] arr;
	public static boolean[][] visited;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};
	public static int v,o,sumV=0,sumO=0;
	public static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i=0; i<r; i++) {
			String in = br.readLine();
			for(int j=0; j<c; j++) {
				arr[i][j] = in.charAt(j);
			}
		}
		for(int i=1; i<r-1; i++) {
			for(int j=1; j<c-1; j++) {
				check=false;
				v=0; o=0;
				if(arr[i][j]!='#'&&!visited[i][j]) {
					dfs(i,j);
				}
				if(!check) {
					if(v<o) {
						sumO+=o;
					}
					else {
						sumV+=v;
					}
				}
			}
		}
		System.out.println(sumO+" "+sumV);
		
	}
	public static boolean range(int y, int x) {
		if(y>=0&&y<r&&x>=0&&x<c) {
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
			if(!range(curY, curX)) {
				check = true;
				return;
			}
			else if(arr[curY][curX]!='#'&&!visited[curY][curX]) {
				dfs(curY,curX);
			}
		}
		if(arr[y][x]=='v') {
			v++;
		}
		else if(arr[y][x]=='o') {
			o++;
		}
	}

}
