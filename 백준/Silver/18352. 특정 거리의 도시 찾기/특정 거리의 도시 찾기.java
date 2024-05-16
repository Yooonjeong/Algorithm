
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int n, m, k, x;
	public static ArrayList<Integer>[] arr;
	public static boolean[] visited;
	public static Deque<int[]> q;
	public static ArrayList<Integer> answer;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+1];
		visited = new boolean[n+1];
		q = new ArrayDeque<>();
		answer = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		int a, b;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
		}
		bfs(x);
		Collections.sort(answer);
		StringBuilder sb = new StringBuilder();
		if(answer.isEmpty()) {
			sb.append("-1");
		}
		else {
			for(int i=0; i<answer.size(); i++) {
				sb.append(answer.get(i)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs(int root) {
		visited[root] = true;
		q.offerLast(new int[] {root,0});
		int depth=0;
		while(!q.isEmpty()) {
			int cur[] = q.pollFirst();
			depth = cur[1];
			if(!arr[cur[0]].isEmpty()) {
				for(Integer e: arr[cur[0]]) {
					if(!visited[e]) {
						visited[e] = true;
						q.offerLast(new int[] {e, depth+1});
					}
				}
			}
			if(depth==k) {
				answer.add(cur[0]);
			}
		}
	}
}
