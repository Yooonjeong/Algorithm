import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char at = s.charAt(i);
            if(at=='('){
                stack.add(at);
            }
            else if(at==')'){
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }
                stack.poll();
            }
        }
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}