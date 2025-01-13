import java.util.*;

class Solution {
    public boolean[][] visited;
    public int n, m;
    public Queue<int[]> queue;
    public int[] dirX = {0, 1, 0, -1};
    public int[] dirY = {1, 0, -1, 0};
    public int answer = -1;
    public int solution(int[][] maps) {
        queue = new ArrayDeque<>();
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        bfs(maps);
        return answer;
    }
    public boolean range(int y, int x){
        if(y>=0 && y<n && x>=0 && x<m){
            return true;
        }
        return false;
    }
    public void bfs(int[][] maps){
        int curX, curY;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i=0; i<4; i++){
                curY = cur[0]+dirY[i];
                curX = cur[1]+dirX[i];
                if(range(curY, curX) && maps[curY][curX]==1 && !visited[curY][curX]){
                    if(curY==n-1&&curX==m-1){
                        answer = cur[2]+1;
                        return;
                    }
                    queue.offer(new int[]{curY, curX, cur[2]+1});
                    visited[curY][curX] = true;
                }
            }
        }
    }
}