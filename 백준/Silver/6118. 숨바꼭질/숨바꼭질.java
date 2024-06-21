
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int n,m;
	public static ArrayList<Integer>[] arr;
	public static boolean[] visited;
	public static Deque<int[]> q;
	public static int ans=0, cnt=0, max=-1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		visited = new boolean[n+1];

		q = new ArrayDeque<>();
		int a,b;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		bfs();

		StringBuilder sb = new StringBuilder();
		sb.append(ans).append(" ").append(max).append(" ").append(cnt);
		System.out.println(sb.toString());
		
	}
	public static void bfs() {
		visited[1] = true;
		q.offerLast(new int[]{1,0});
		int curN, depth;
		while(!q.isEmpty()) {
			int cur[] = q.pollFirst();
			curN = cur[0];
			depth = cur[1];
			if(!arr[curN].isEmpty()) {
				for(Integer e:arr[curN]) {
					if(!visited[e]) {
						q.offerLast(new int[]{e,depth+1});
						visited[e] = true;
					}
				}
			}
			if(depth>max) {
				max = depth;
				cnt=0;
				ans = curN;
			}
			if(depth==max) {
				cnt++;
				if(curN<ans) {
					ans = curN;
				}
			}
		}
	}
}
