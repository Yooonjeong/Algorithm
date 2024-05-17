
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static String[][] arr;
	public static boolean[][] visited;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};
	public static Deque<int[]> q;
	public static int answer=10001;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String in;
		arr = new String[n][m];
		visited = new boolean[n][m];
		q = new ArrayDeque<>();
		for(int i=0; i<n; i++) {
			in = br.readLine();
			String at[] = in.split("");
			arr[i] = at;
		}
		bfs(0,0);
		System.out.println(answer);
		
	}
	public static boolean range(int y, int x) {
		if(y>=0&&y<n&&x>=0&&x<m) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void bfs(int y, int x) {
		visited[y][x] = true;
		q.offerLast(new int[] {y,x,1});
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			for(int i=0; i<4; i++) {
				int curY = cur[0]+dirY[i];
				int curX = cur[1]+dirX[i];
				if(range(curY, curX)&&arr[curY][curX].equals("1")&&!visited[curY][curX]) {
					q.offerLast(new int[] {curY, curX, cur[2]+1});
					visited[curY][curX] = true;
				}
			}
			if(cur[0]==n-1&&cur[1]==m-1) {
				answer = Math.min(answer, cur[2]);
			}
		}
	}

}
