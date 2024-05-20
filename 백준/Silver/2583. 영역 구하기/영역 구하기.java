
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static int m, n, k;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};
	public static int cnt;
	public static ArrayList<Integer> answer;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		visited = new boolean[m][n];
		int x1,x2,y1,y2;
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for(int y=y1; y<y2; y++) {
				for(int x=x1; x<x2; x++) {
					arr[y][x] = 1;
				}
			}
		}
		answer = new ArrayList<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==0&&!visited[i][j]) {
					cnt=0;
					dfs(i,j);
					answer.add(cnt);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		Collections.sort(answer);
		int size = answer.size();
		sb.append(size).append("\n");
		for(int i=0; i<size; i++) {
			sb.append(answer.get(i)).append(" ");
		}
		System.out.println(sb.toString());
		
	}
	public static boolean range(int y, int x) {
		if(y>=0 && y<m&&x>=0&&x<n) {
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
			if(range(curY,curX)&&arr[curY][curX]==0&&!visited[curY][curX]) {
				dfs(curY, curX);
			}
		}
		cnt++;
	}

}
