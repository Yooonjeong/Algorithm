
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[] arr;
	public static boolean[] visited;
	public static Deque<int[]> q;
	public static int answer=-1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		visited = new boolean[n+1];
		q = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		bfs();
		System.out.println(answer);
		
	}
	public static boolean range(int x) {
		if(x>0&&x<=n) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void bfs() {
		if(n==1) {
			answer = 0;
			return;
		}
		visited[1] = true;
		int cur = arr[1];
		for(int i=1; i<=cur; i++) {
			if(range(1+i)&&!visited[1+i]) {
				q.offerLast(new int[] {1+i, 1});
				visited[1+i] = true;
			}
		}
		while(!q.isEmpty()) {
			int curArr[] = q.pollFirst();
			cur = curArr[0];
			for(int i=1; i<=arr[curArr[0]]; i++) {
				if(range(cur+i)&&!visited[cur+i]) {
					q.offerLast(new int[] {cur+i, curArr[1]+1});
					visited[cur+i] = true;
				}
			}
			if(cur==n) {
				if(answer==-1) {
					answer = curArr[1];
				}
				else {
					answer = Math.min(answer, curArr[1]);	
				}
			}
		}
		
	}
}
