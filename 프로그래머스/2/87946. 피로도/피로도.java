class Solution {
    public static boolean[] visited;
    public static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        
        return answer;
    }
    public void dfs(int[][] dungeons, int k, int depth) {
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && dungeons[i][0]<=k){
                visited[i]=true;
                dfs(dungeons, k-dungeons[i][1], depth+1);
                visited[i]=false;
            }
        }
        answer = Math.max(answer, depth);
    }
}