
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int l,x1,x2,y1,y2;
	public static Deque<int[]> q;
	public static int[] dirX = {1,2,2,1,-1,-2,-2,-1};
	public static int[] dirY = {-2,-1,1,2,2,1,-1,-2};
	public static boolean[][] visited;
	public static int tcnt;


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			q = new ArrayDeque<>();
			l = Integer.parseInt(br.readLine());
			visited = new boolean[l][l];
			st = new StringTokenizer(br.readLine());
			y1 = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			y2 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			tcnt=l*l+1;
			bfs();
			sb.append(tcnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean range(int y, int x) {
		if(y>=0&&y<l&&x>=0&&x<l) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void bfs() {
		visited[y1][x1] = true;
		q.offerLast(new int[] {y1,x1,0});
		while(!q.isEmpty()) {
			int cur[] = q.pollFirst();
			int depth = cur[2];
			for(int i=0; i<8; i++) {
				int curY = cur[0]+dirY[i];
				int curX = cur[1]+dirX[i];
				if(range(curY,curX)&&!visited[curY][curX]) {
					visited[curY][curX] = true;
					q.add(new int[] {curY,curX,depth+1});
				}
			}
			if(cur[0]==y2&&cur[1]==x2) {
				tcnt=Math.min(tcnt, depth);
			}
		}
	}
}
