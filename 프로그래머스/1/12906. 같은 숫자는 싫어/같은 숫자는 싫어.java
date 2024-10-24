import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Deque<Integer> list = new ArrayDeque<>();
        list.addLast(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(list.peekLast()!=arr[i]){
                list.addLast(arr[i]);
            }
        }
        answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
}