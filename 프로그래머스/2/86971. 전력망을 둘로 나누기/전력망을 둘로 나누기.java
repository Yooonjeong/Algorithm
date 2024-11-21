import java.util.*;

class Solution {
    public ArrayList<Integer>[] arr;
    public boolean[] visited;
    public int cnt=0, answer=Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        arr = new ArrayList[n+1];
        for(int i=1; i<=n;i++){
            arr[i] = new ArrayList<>();
        }
        int a,b;
        for(int i=0; i<wires.length; i++){
            a = wires[i][0];
            b = wires[i][1];
            arr[a].add(b);
            arr[b].add(a);
        }
        for(int i=0; i<wires.length; i++){
            visited = new boolean[n+1];
            a = wires[i][0];
            b = wires[i][1];
            arr[a].remove(Integer.valueOf(b));
            arr[b].remove(Integer.valueOf(a));
            cnt=0;
            dfs(1);
            int diff = Math.abs(cnt-(n-cnt));
            answer = Math.min(answer, diff);
            arr[a].add(b);
            arr[b].add(a);
        }
        return answer;
    }
    public void dfs(int n){
        visited[n] = true;
        cnt++;
        if(!arr[n].isEmpty()){
            for(int i=0; i<arr[n].size(); i++){
                if(!visited[arr[n].get(i)]){
                    dfs(arr[n].get(i));
                }
            }
        }
    }
}