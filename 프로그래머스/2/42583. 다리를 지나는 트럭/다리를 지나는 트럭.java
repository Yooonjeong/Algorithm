import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, idx = 0;
        int curWeight = 0, len = truck_weights.length;
        Deque<Integer> queue = new ArrayDeque<>();
        if(truck_weights.length == 1) {
            return bridge_length+1;
        }
        if(bridge_length == 1) {
            return len+1;
        }
        for(int i=0; i<bridge_length; i++){
            queue.offer(0);
        }
        while(idx<len){
            curWeight -= queue.poll();
            answer++;
            int curTruck = truck_weights[idx];
            if(curTruck+curWeight<=weight){
                queue.offer(curTruck);
                curWeight += curTruck;
                idx++;
            }
            else{
                queue.offer(0);
            }
        }
        answer += bridge_length;
        
        return answer;
    }
}