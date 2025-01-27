
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		int V, E, K;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		int[] dp = new int[V+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		Map<Integer, Integer>[] graph = new HashMap[V+1];
		boolean[] visited = new boolean[V+1];
		for(int i=1; i<=V; i++) {
			graph[i] = new HashMap<>();
		}
		int u, v, w;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			if(!graph[u].containsKey(Integer.valueOf(v))) {
				graph[u].put(Integer.valueOf(v), Integer.valueOf(w));
			}
			else if(w<graph[u].get(Integer.valueOf(v))){
				graph[u].put(Integer.valueOf(v), Integer.valueOf(w));
			}
		}
		PriorityQueue<Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b)-> a.getValue().compareTo(b.getValue()));
		queue.offer(new AbstractMap.SimpleEntry(K, 0));
		dp[K] = 0;
		int curN, nodeN, nodeW;
		while(!queue.isEmpty()) {
			Entry<Integer, Integer> cur = queue.poll();
			curN = cur.getKey();
			visited[curN] = true;
			for(Entry<Integer, Integer> node:graph[curN].entrySet()) {
				nodeN = node.getKey();
				nodeW = node.getValue();
				if(!visited[nodeN] && dp[curN]+nodeW<dp[nodeN]) {
					dp[nodeN] = dp[curN]+nodeW;
					node.setValue(dp[nodeN]);
					queue.offer(node);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			sb.append(dp[i] == Integer.MAX_VALUE ? "INF" : dp[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
