
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dirX = {-1,0,1,1,1,0,-1,-1};
	public static int[] dirY = {-1,-1,-1,0,1,1,1,0};
	public static Deque<int[]> q;
	public static int max=-1,cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		q = new ArrayDeque<>();

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visited = new boolean[n][m];
				cnt=100;
				bfs(i,j,0);	
				max = Math.max(max, cnt);
			}
		}
		System.out.println(max);
	}
	public static boolean range(int y, int x) {
		if(y>=0&&y<n&&x>=0&&x<m) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void bfs(int y, int x, int depth) {
		visited[y][x] = true;
		q.offerLast(new int[] {y,x,depth});
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			if(arr[cur[0]][cur[1]]==1) {
				cnt = Math.min(cnt, cur[2]);	
			}
			for(int i=0; i<8; i++) {
				int curX = cur[1]+dirX[i];
				int curY = cur[0]+dirY[i];
				if(range(curY,curX)&&!visited[curY][curX]) {
					q.offerLast(new int[] {curY,curX,cur[2]+1});
					visited[curY][curX] = true;
				}
			}

		}
	}
}
