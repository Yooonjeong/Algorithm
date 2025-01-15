import java.util.*;

class Solution {
    public ArrayList<String> result = new ArrayList<>();
    public boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(result);
        
        return result.get(0).split(" ");
    }
    public void dfs(int depth, String start, String route, String[][] tickets){
        if(depth==tickets.length){
            result.add(route);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(start) && !visited[i]){
                visited[i] = true;
                dfs(depth+1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}