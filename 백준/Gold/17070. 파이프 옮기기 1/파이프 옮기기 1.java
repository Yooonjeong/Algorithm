
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[][] arr;
	public static int cnt=0;
	public static LinkedList<int[]> queue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		queue = new LinkedList<>();
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(arr[n-1][n-1]==1) {
			System.out.println("0");
			return;
		}
		bfs();
		System.out.println(cnt);
	}
	public static boolean range(int y, int x) {
		if(y>=0&&y<n&&x>=0&&x<n&&arr[y][x]==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean range2(int y, int x) {
		if(y>=0&&y<n&&x>=0&&x<n&&arr[y-1][x]==0&&arr[y][x]==0&&arr[y][x-1]==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void bfs() {
		queue.offer(new int[] {0, 0, 1});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[1]==n-1&&cur[2]==n-1) {
				cnt++;
				continue;
			}
			int dir = cur[0];
			if(dir==0) {
				if(range(cur[1], cur[2]+1)) {
					queue.offer(new int[] {0, cur[1], cur[2]+1});
				}
				if(range2(cur[1]+1, cur[2]+1)){
					queue.offer(new int[] {2, cur[1]+1, cur[2]+1});
				}
			}
			else if(dir==1) {
				if(range(cur[1]+1, cur[2])) {
					queue.offer(new int[] {1, cur[1]+1, cur[2]});
				}
				if(range2(cur[1]+1, cur[2]+1)) {
					queue.offer(new int[] {2, cur[1]+1, cur[2]+1});
				}
			}
			else if(dir==2) {
				if(range(cur[1], cur[2]+1)) {
					queue.offer(new int[] {0, cur[1], cur[2]+1});
				}
				if(range(cur[1]+1, cur[2])) {
					queue.offer(new int[] {1, cur[1]+1, cur[2]});
				}
				if(range2(cur[1]+1, cur[2]+1)) {
					queue.offer(new int[] {2, cur[1]+1, cur[2]+1});
				}
			}
		}
	}
}

