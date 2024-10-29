import java.util.*;

class Solution {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        for(String s:operations){
            operation(s);
        }
        if(!min.isEmpty()){
            answer[0] = max.peek();
            answer[1] = min.peek();
        }
        return answer;
    }
    
    public void operation(String in){
        switch(in){
            case "D 1":
                if(!max.isEmpty()){
                    int front = max.poll();
                    min.remove(front);
                }
                break;
            case "D -1":
                if(!min.isEmpty()){
                    int front = min.poll();
                    max.remove(front);
                }
                break;
            default:
                String[] cur = in.split(" ");
                min.add(Integer.valueOf(cur[1]));
                max.add(Integer.valueOf(cur[1]));
                break;
        }
    }
}