
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static long a, b;
	public static long min=Long.MAX_VALUE;
	public static LinkedList<long[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		bfs(a,0);
		if(min==Long.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.println(min+1);
		}
	}
	public static void bfs(long n, long depth) {
		queue.offer(new long[] {n, depth});
		while(!queue.isEmpty()) {
			long[] cur = queue.poll();
			long num=cur[0];
			if(num==b) {
				min = Math.min(cur[1], min);
			}
			if(num*2<=b) {
				queue.offer(new long[] {num*2, cur[1]+1});
			}
			if(num*10+1<=b) {
				queue.offer(new long[] {num*10+1, cur[1]+1});
			}
		}
	}
}
