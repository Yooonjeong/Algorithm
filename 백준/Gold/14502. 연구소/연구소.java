
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int[][] map;
	public static LinkedList<Point> queue;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};
	public static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		queue = new LinkedList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(ans);
	}
	public static boolean range(int y, int x) {
		if(y>=0&&y<n&&x>=0&&x<m) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void dfs(int cnt) {
		if(cnt==3) {
			bfs();
			return;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					dfs(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	public static void bfs() {
		int[][] copyMap = new int[n][m];
		for(int i=0; i<n; i++) {
			copyMap[i] = map[i].clone();
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==2) {
					queue.offer(new Point(j, i));
				}
			}
		}
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			for(int i=0; i<4; i++) {
				int curY = cur.getY()+dirY[i];
				int curX = cur.getX()+dirX[i];
				if(range(curY,curX)&&copyMap[curY][curX]==0) {
					copyMap[curY][curX] = 2;
					queue.add(new Point(curX,curY));
				}
			}
		}
		safezone(copyMap);
	}
	public static void safezone(int[][] copyMap) {
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copyMap[i][j]==0) {
					cnt++;
				}
			}
		}
		if(cnt>ans) {
			ans = cnt;
		}
	}
}
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
