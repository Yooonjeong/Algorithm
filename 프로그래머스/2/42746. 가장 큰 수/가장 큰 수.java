import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int len = numbers.length;
        String[] numstr = new String[len];
        for(int i=0; i<len; i++){
            numstr[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(numstr, (o1, o2)->(o2+o1).compareTo(o1+o2));
        
        if(numstr[0].equals("0")){
            return "0";
        }
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<len; i++){
            answer.append(numstr[i]);
        }
        return answer.toString();
    }
}