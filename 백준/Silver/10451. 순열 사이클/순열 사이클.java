
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] arr;
	public static boolean[] check;
	
	public static void dfs(int start) {
		check[start] = true;
		int next = arr[start];
		if(!check[next]) {
			dfs(next);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			check = new boolean[n+1];
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int cycle=0;
			for(int j=1; j<=n; j++) {
				if(!check[j]) {
					dfs(j);
					cycle++;
				}
			}
			sb.append(cycle).append("\n");
		}
		System.out.println(sb.toString());
	}

}
