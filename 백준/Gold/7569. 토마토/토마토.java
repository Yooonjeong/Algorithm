
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int n, m, h;
	public static int max = -1;
	public static int[][][] arr;
	public static int[] dirX = {0,0,-1,1,0,0};
	public static int[] dirY = {0,0,0,0,-1,1};
	public static int[] dirZ = {-1,1,0,0,0,0};
	public static LinkedList<int[]> queue;
	public static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h][n][m];
		queue = new LinkedList<>();
		visited = new boolean[h][n][m];
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int l=0; l<m; l++) {
					arr[i][j][l] = Integer.parseInt(st.nextToken());
				}
			}
		}
		bfs();
		check();
		System.out.println(max);
	}
	public static boolean range(int z, int y, int x) {
		if(z>=0&&z<h&&y>=0&&y<n&&x>=0&&x<m) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void bfs() {
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int l=0; l<m; l++) {
					if(arr[i][j][l]==1) {
						queue.offer(new int[] {i,j,l,0});
						visited[i][j][l] = true;
					}
				}
			}
		}
		if(queue.isEmpty()) {
			max = 0;
			return;
		}
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			max = cur[3];
			for(int i=0; i<6; i++) {
				int curZ = cur[0]+dirZ[i];
				int curY = cur[1]+dirY[i];
				int curX = cur[2]+dirX[i];
				if(range(curZ, curY, curX)&&!visited[curZ][curY][curX]&&arr[curZ][curY][curX]==0) {
					arr[curZ][curY][curX] = 1;
					visited[curZ][curY][curX] = true;
					queue.offer(new int[] {curZ, curY, curX, cur[3]+1});
				}
			}
		}
	}
	public static void check() {
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int l=0; l<m; l++) {
					if(arr[i][j][l]==0) {
						max = -1;
						return;
					}
				}
			}
		}
	}
}
