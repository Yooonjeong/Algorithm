
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Integer>[] arr;
	public static boolean visited[];


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		visited = new boolean[n+1];
		int a, b;
		StringTokenizer st;
		for(int i=0; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		if(!arr[1].isEmpty()) {
			dfs(1,0);
		}
		int answer = 0;
		for(int i=2; i<visited.length; i++) {
			if(visited[i]) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	public static void dfs(int start, int depth) {
		if(depth>=2) {
			return;
		}
		if(!arr[start].isEmpty()) {
			for(Integer e:arr[start]) {
				visited[e] = true;
				dfs(e, depth+1);
			}
		}
	}

}
