import java.util.*;

class Solution {
    public int[][] map = new int[101][101];
    public int[] dirX = {0, 0, -1, 1};
    public int[] dirY = {-1, 1, 0, 0};
    public Queue<int[]> queue;
    public boolean[][] visited = new boolean[101][101];
    public int answer;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        queue = new LinkedList<>();
        for(int i=0; i<rectangle.length; i++){
            draw(rectangle[i][0]*2, rectangle[i][1]*2, rectangle[i][2]*2, rectangle[i][3]*2);
        }
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        return answer;
    }
    public void draw(int x1, int y1, int x2, int y2){
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if((i==x1 || i==x2 || j==y1 || j==y2)&&map[i][j]!=2){
                    map[i][j] = 1;
                }
                else{
                    map[i][j] = 2;
                }
            }
        }
    }
    public boolean range(int x, int y){
        if(x>=0 && x<=100 && y>=0 && y<=100){
            return true;
        }
        else return false;
    }
    public void bfs(int x, int y, int itemX, int itemY){
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;
        
        int curX, curY;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i=0; i<4; i++){
                curX = cur[0]+dirX[i];
                curY = cur[1]+dirY[i];
                if(range(curX, curY) && map[curX][curY]==1 && !visited[curX][curY]){
                    if(curX==itemX && curY==itemY){
                        answer = (cur[2]+1)/2;
                        return;
                    }
                    queue.offer(new int[]{curX, curY, cur[2]+1});
                    visited[curX][curY] = true;
                }
            }
        }
    }
}