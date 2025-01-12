import java.util.*;

class Solution {
    public boolean[] visited;
    public ArrayList<Integer>[] arr;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i != j && computers[i][j] == 1){
                    arr[i].add(j);
                }
            }
        }
        int cnt=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int i){
        visited[i] = true;
        if(!arr[i].isEmpty()){
            for(int j : arr[i]){
                if(!visited[j]){
                    dfs(j);
                }
            }
        }
    }
}