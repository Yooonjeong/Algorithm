
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int f,s,g,u,d;
	public static boolean[] visited;
	public static int[] arr;
	public static Deque<Integer> q;
	public static int minSum=-1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		arr = new int[f+1];
		visited = new boolean[f+1];
		q = new ArrayDeque<>();
		
		bfs();
		if(minSum==-1) {
			System.out.println("use the stairs");
		}
		else {
			System.out.println(minSum);
		}
	}
	public static boolean upRange(int cur) {
		if(cur+u<=f) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean downRange(int cur) {
		if(cur-d>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void bfs() {
		visited[s] = true;
		q.offerLast(s);
		while(!q.isEmpty()) {
			int cur = q.pollFirst();
			if(upRange(cur)&&!visited[cur+u]) {
				visited[cur+u]=true;
				arr[cur+u] = arr[cur]+1;
				q.offerLast(cur+u);
			}
			if(downRange(cur)&&!visited[cur-d]) {
				visited[cur-d]=true;
				arr[cur-d] = arr[cur]+1;
				q.offerLast(cur-d);
			}
			if(cur==g) {
				if(minSum==-1) {
					minSum = arr[cur];
				}
				else {
					minSum = Math.min(minSum, arr[cur]);
				}
			}
		}
	}

}
