
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int[] dirX = {0,0,-1,1};
	public static int[] dirY = {-1,1,0,0};
	public static ArrayList<String> answer;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		answer = new ArrayList<>();
		StringTokenizer st;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				dfs(i,j,"");
			}
		}
		System.out.println(answer.size());
	}
	public static boolean range(int y, int x) {
		if(y>=0&&y<5&&x>=0&&x<5) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void dfs(int y, int x, String str) {
		if(str.length()>=6) {
			if(!answer.contains(str)) {
				answer.add(str);
			}
			return;
		}
		str+=String.valueOf(arr[y][x]);
		for(int i=0; i<4; i++) {
			int curX = x+dirX[i];
			int curY = y+dirY[i];
			if(range(curY,curX)) {
				dfs(curY,curX,str);
			}
		}
	}

}
