
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static String[][] arr;
	public static boolean[][] visited;
	public static int n, cnt, atcnt;
	public static ArrayList<Integer> answer;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new String[n][n];
		answer = new ArrayList<>();
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String in = br.readLine();
			String[] at = in.split("");
			arr[i] = at;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[j][i].equals("1")&&!visited[j][i]) {
					atcnt=0;
					dfs(j,i);
					cnt++;
					answer.add(atcnt);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		Collections.sort(answer);
		for(int i=0; i<answer.size(); i++) {
			sb.append(answer.get(i)).append("\n");
		}
		System.out.println(sb.toString());
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
		atcnt++;
		for(int i=0; i<4; i++) {
			int curY = y + dirY[i];
			int curX = x + dirX[i];
			if(range(curY,curX)&&arr[curY][curX].equals("1")&&!visited[curY][curX]) {
				dfs(curY, curX);
			}
		}
	}
}
