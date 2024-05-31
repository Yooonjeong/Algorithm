
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static boolean[][] visited;
	public static int n,m;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};
	public static int answer;
	public static Deque<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		q = new ArrayDeque<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					q.offerLast(new int[] {i,j,0});
					visited[i][j] = true;
				}
			}
		}
		bfs();
		if(check()) {
			System.out.println(answer);
		}
		else {
			System.out.println("-1");
		}
		
	}
	public static boolean check() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean range(int y, int x) {
		if(y>=0&&y<n&&x>=0&&x<m) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void bfs() {

		answer = 0;
		
		while(!q.isEmpty()) {
			int cur[] = q.pollFirst();
			answer = cur[2];
			for(int i=0; i<4; i++) {
				int curX = cur[1]+dirX[i];
				int curY = cur[0]+dirY[i];
				if(range(curY,curX)&&!visited[curY][curX]&&arr[curY][curX]==0) {
					arr[curY][curX]=1;
					visited[curY][curX] = true;
					q.offerLast(new int[] {curY, curX, cur[2]+1});
				}
			}
		}
	}

}
