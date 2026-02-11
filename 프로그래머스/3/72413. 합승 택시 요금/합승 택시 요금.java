import java.util.*;

class Solution {
    private Map<Integer, Integer>[] path;
    private int[] distI;
    private int[] distA;
    private int[] distB;
    private int n;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        path = new HashMap[n+1];
        
        for (int i=1; i<=n; i++) {
            path[i] = new HashMap<>();
        }
        
        for (int i=0; i<fares.length; i++) {
            path[fares[i][0]].put(fares[i][1], fares[i][2]);
            path[fares[i][1]].put(fares[i][0], fares[i][2]);
        }
        
        distI = dijkstra(s);
        distA = dijkstra(a);
        distB = dijkstra(b);
        
        int answer = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            answer = Math.min(answer, distI[i] + distA[i] + distB[i]);
        }
        
        return answer;
    }
    
    private int[] dijkstra(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        pq.add(new int[] {s, 0});
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            
            if (dist[node] != cost) continue;
            
            for(Map.Entry<Integer, Integer> p : path[node].entrySet()) {
                int nextNode = p.getKey();
                int pathCost = p.getValue();
                
                int nextCost = dist[node] + pathCost;
                if (dist[nextNode] > nextCost) {
                    dist[nextNode] = nextCost;
                    pq.add(new int[] {nextNode, nextCost});
                }
            }
        }
        
        return dist;
    }
}