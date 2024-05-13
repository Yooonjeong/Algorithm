
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int arr[][];
	public static boolean check[][];
	public static int w, h, curX, curY;
	public static int[] dirX = {0,0,1,-1,-1,1,-1,1};
	public static int[] dirY = {-1,1,0,0,-1,-1,1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0) {
				break;
			}
			arr = new int[h][w];
			check = new boolean[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt=0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!check[i][j]&&arr[i][j]==1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	public static boolean range() {
		if(curX>=0 && curX<w && curY>=0 && curY<h) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void dfs(int y, int x) {
		check[y][x] = true;
		
		for(int i=0; i<8; i++) {
			curX = x+dirX[i];
			curY = y+dirY[i];
			if(range()&& !check[curY][curX] && arr[curY][curX]==1) {
				dfs(curY, curX);
			}
		}
		
	}

}
