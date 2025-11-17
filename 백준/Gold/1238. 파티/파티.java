import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static List<int[]>[] origin;
    private static List<int[]>[] reverse;
    private static int n, m, x;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        origin = new ArrayList[n+1];
        reverse = new ArrayList[n+1];
        
        for (int i=1; i<=n; i++) {
            origin[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        
        int start, end, power;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            power = Integer.parseInt(st.nextToken());

            origin[start].add(new int[] { end, power });
            reverse[end].add(new int[] { start, power });
        }

        int[] go = dijkstra(origin);
        int[] back = dijkstra(reverse);

        int ans = 0;
        for (int i=1; i<=n; i++) {
            ans = Math.max(ans, go[i]+back[i]);
        }
        System.out.println(ans);
    }
    private static int[] dijkstra(List<int[]>[] edges) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[x] = 0;
        pq.add(new int[] { x, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            
            if (dist[node] != cost) continue;

            for (int[] edge : edges[node]) {
                int next = edge[0];
                int weight = edge[1];
                if (dist[node] + weight >= dist[next]) continue;

                dist[next] = dist[node] + weight;
                pq.add(new int[] { next, dist[next] });
            }
        }
        return dist;
    }
}
