import java.util.*;

class Solution {
    public boolean[] visited;
    public Queue<int[]> queue;
    public int answer = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        queue = new ArrayDeque<>();
        
        bfs(begin, target, words);
        return answer;
    }
    public void check(String cur, String[] words, int depth, String target){
        for(int i=0; i<words.length; i++){
            String word = words[i];
            int cnt=0;
            for(int j=0; j<word.length(); j++){
                if(cur.charAt(j)!=word.charAt(j)){
                    cnt++;
                }
            }
            if(cnt==1 && !visited[i]){
                queue.add(new int[]{i, depth+1});
                visited[i] = true;
            }
        }
    }
    public void bfs(String begin, String target, String[] words){
        check(begin, words, 0, target);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(target.equals(words[cur[0]])){
                answer = cur[1];
                return;
            }
            check(words[cur[0]], words, cur[1], target);
        }
    }
}