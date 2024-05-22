
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int n, k;
	public static Deque<int[]> q;
	public static int[] arr;
	public static boolean[] visited;
	public static int answer=1000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		q = new ArrayDeque<>();
		arr = new int[200001];
		visited = new boolean[200001];
		bfs(n);
		System.out.println(answer);
	}

	public static int[] location(int x) {
		return new int[] {x-1,x+1,2*x};
	}
	public static boolean range(int x) {
		if(x>=0&&x<=200000) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void bfs(int x) {
		visited[x] = true;
		q.offerLast(new int[] {x,0});
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			int loc[] = location(cur[0]);
			for(int i=0; i<3; i++) {
				int curLoc = loc[i];
				if(range(curLoc)&&!visited[curLoc]) {
					q.offerLast(new int[] {curLoc, cur[1]+1});	
					visited[curLoc] = true;
				}
			}
			if(cur[0]==k) {
				answer = Math.min(answer, cur[1]);
			}
		}
	}
}
