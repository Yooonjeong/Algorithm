import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] sub;
        int len = commands.length;
        int[] answer = new int[len];
        for(int i=0; i<len; i++){
            sub = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(sub);
            answer[i] = sub[commands[i][2]-1];
        }
        return answer;
    }
}