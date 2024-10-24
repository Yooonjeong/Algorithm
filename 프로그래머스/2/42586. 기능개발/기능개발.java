import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> answerList = new ArrayDeque<>();

        for(int i=0; i<progresses.length; i++){
            int rest = 100-progresses[i];
            queue.addLast((int) Math.ceil((double)rest/speeds[i]));
        }
        int front = queue.pollFirst();
        int cnt = 1; 
        while(!queue.isEmpty()){
        	int cur = queue.pollFirst();
            if(cur<=front){
                cnt++;
            }
            else{
                answerList.addLast(cnt);
                front = cur;
                cnt = 1;
            }
        }
        answerList.add(cnt);
        
        answer = answerList.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}