
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static ArrayList<Integer>[] arr;
	public static boolean[] visited;
	public static Deque<int[]> q;
	public static int min;
	public static ArrayList<Integer> answer;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		q = new ArrayDeque<>();
		min = 5001;
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		int a,b;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		int minAnswer=5001;
		answer = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			int sum=0;
			for(int j=1; j<=n; j++) {
				if(i==j) {continue;}
				min = 5001;
				visited = new boolean[n+1];
				q = new ArrayDeque<>();
				
				bfs(i,j);
				sum+=min;
			}
			if(minAnswer>sum) {
				minAnswer = sum;
				answer.clear();
				answer.add(i);
			}
			if(minAnswer==sum) {
				answer.add(i);
			}
		}
		Collections.sort(answer);
		System.out.println(answer.get(0));
		
	
	}

	public static void bfs(int from, int to) {
		visited[from] = true;
		q.offerLast(new int[] {from, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			int curN = cur[0];
			if(!arr[curN].isEmpty()) {
				for(Integer e:arr[curN]) {
					if(!visited[e]) {
						q.offerLast(new int[] {e, cur[1]+1});
						visited[e] = true;
					}
				}
			}
			if(curN==to) {
				min = Math.min(cur[1], min);
			}
		}
	}

}
