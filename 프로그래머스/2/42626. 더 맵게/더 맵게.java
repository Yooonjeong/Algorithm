import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int e:scoville){
            pq.add(e);
        }
        
        int front = pq.peek();
        while(front<K){
            if(pq.size()<2){
                answer = -1;
                break;
            }
            pq.add(pq.poll()+(pq.poll()*2));
            answer++;
            front = pq.peek();
        }
        return answer;
    }
}