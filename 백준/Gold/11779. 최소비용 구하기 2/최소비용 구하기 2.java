import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Main {
    private static HashMap<Integer, Integer>[] graph;
    private static int n, m, s, e;
    private static int[] prev;
    private static int[] dist;
    private static int cnt = 0;
    private static long cost = 0;
    private static StringBuilder path = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new HashMap[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new HashMap<>();
        }
        prev = new int[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        StringTokenizer st;
        int start, end, weight;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            if ((!graph[start].containsKey(end)) || (graph[start].containsKey(end) && graph[start].get(end) > weight)) {
                graph[start].put(end, weight);
            }
        }
        
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dijkstra();
        System.out.println(cost);
        System.out.println(cnt);
        System.out.println(path.toString());
    }
    private static void dijkstra() {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[] {s, 0});
        dist[s] = 0;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int) cur[0];
            long weight = cur[1];

            if (dist[node] != weight) continue;

            if (node == e) {
                cost = dist[e];
                List<Integer> route = new ArrayList<>();
                int idx = e;
                while (idx != 0) {
                    route.add(idx);
                    idx = prev[idx];
                }
                Collections.reverse(route);
                cnt = route.size();
                for (int p : route) path.append(p).append(" ");

                return;
            }

            for (Entry<Integer, Integer> edge : graph[node].entrySet()) {
                int nextNode = edge.getKey();
                int nextWeight = edge.getValue();
                if (dist[node] + nextWeight >= dist[nextNode]) continue;

                dist[nextNode] = dist[node] + nextWeight;
                pq.add(new long[] {nextNode, dist[nextNode]});
                prev[nextNode] = node;
            }
        }
    }
}
