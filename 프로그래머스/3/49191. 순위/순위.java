import java.util.*;

class Solution {
    private boolean[][] visited;
    private ArrayList<Integer>[] graph;
    
    public int solution(int n, int[][] results) {
        visited = new boolean[n+1][n+1];
        graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] r : results) {
            graph[r[0]].add(r[1]);
        }
        
        int answer = 0;
        for (int i=1; i<=n; i++) {
            dfs(i, i);
        }
        for (int i=1; i<=n; i++) {
            int cnt=0;
            for (int j=1; j<=n; j++) {
                if (visited[i][j] || visited[j][i]) cnt++;
            }
            if (cnt >= n) answer++;
        }
          
        return answer;
    }
    
    private void dfs(int start, int reached) {
        visited[start][reached] = true;
        
        for(int next : graph[reached]) {
            if (!visited[start][next]) {
                dfs(start, next);
            }
        }
    }
}