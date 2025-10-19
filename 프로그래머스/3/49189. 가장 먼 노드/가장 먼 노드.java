import java.util.*;

class Solution {
    private ArrayList<Integer>[] graph;
    private int cnt = 0;
    private int max = 0;
    private boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        bfs();
        
        return cnt;
    }
    
    private void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[1] == max) {
                cnt++;
            }
            if (cur[1] > max) {
                max = cur[1];
                cnt = 1;
            }
            
            for(int next:graph[cur[0]]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, cur[1]+1});
                }
            }
        }
    }
}