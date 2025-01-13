import java.util.*;

class Solution {
    public HashSet<String> visited;
    public Queue<String> queue;
    public HashSet<String> wordSet;
    public int answer = 0;
    public int solution(String begin, String target, String[] words) {
        wordSet = new HashSet<>(Arrays.asList(words));
        visited = new HashSet<>();
        queue = new LinkedList<>();
        
        if(!wordSet.contains(target)){
            return 0;
        }
        
        queue.offer(begin);
        int depth = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String cur = queue.poll();
                for(String word:words){
                    if(!visited.contains(word)&&check(cur, word)){
                        if(word.equals(target)){
                            return depth;
                        }
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
            depth++;
        }
        
        return answer;
    }
    public boolean check(String cur, String target){
        int cnt=0;
        for(int i=0; i<cur.length(); i++){
            if(cur.charAt(i)!=target.charAt(i)){
                if(++cnt>1){
                    return false;
                }
            }
        }
        return true;
    }
}