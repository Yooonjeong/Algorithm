
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static ArrayList<Integer>[] arr;
	public static boolean[] visited;
	public static int[][] answer;
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new ArrayList[n];
		answer = new int[n][n];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			arr[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int at = Integer.parseInt(st.nextToken());
				if(at==1) {
					arr[i].add(j);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			visited = new boolean[n];
			dfs(i,0);
			for(int j=0; j<n; j++) {
				if(visited[j]) {
					answer[i][j] = 1;
				}
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	public static void dfs(int i, int depth) {
		if(depth>0) {
			visited[i] = true;	
		}
		if(!arr[i].isEmpty()) {
			for(Integer e:arr[i]) {
				if(!visited[e]) {
					dfs(e, depth+1);
				}
			}
		}
	}

}
