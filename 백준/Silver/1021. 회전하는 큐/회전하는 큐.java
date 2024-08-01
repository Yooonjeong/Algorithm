
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		int n, m;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		LinkedList<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.offer(i);
		}
		st = new StringTokenizer(br.readLine());
		
		int cnt=0, cur, target;
		for(int i=0; i<m; i++) {
			cur = Integer.parseInt(st.nextToken());
			target = q.indexOf(cur);
			if(target<=q.size()/2) {
				cnt+=target;
				for(int j=0; j<target; j++) {
					int front = q.pollFirst();
					q.offerLast(front);
				}
				q.pollFirst();
			}
			else {
				cnt+=q.size()-target;
				for(int j=0; j<q.size()-target; j++) {
					int back = q.pollLast();
					q.offerFirst(back);
				}
				q.pollFirst();
			}
		}
		System.out.println(cnt);
	}

}
