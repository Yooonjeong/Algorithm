import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        char[] arr = number.toCharArray();
        int n = number.length();
        int front = 0;
        int back = k+1;
        
        while(n-back>=0){
            char max = '0';
            int maxI = front;
            for(int i=front; i<back; i++){
                if(number.charAt(i)>max){
                    max = number.charAt(i);
                    maxI = i;
                }
            }
            answer.append(max);
            front = maxI+1;
            back++;
        }
        
        
        return answer.toString();
    }
}