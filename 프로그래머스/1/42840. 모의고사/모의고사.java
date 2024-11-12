import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] arr = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int size;
        int[] scores = new int[3];
        int len = answers.length;
        
        for(int i=0; i<3; i++){
            size = arr[i].length;
            for(int j=0; j<len; j++){
                if(answers[j]==arr[i][j%size]){
                    scores[i]++;
                }
            }
        }
        int max = Math.max(scores[0],Math.max(scores[1],scores[2]));
        int idx=0;
        for(int i=0; i<3; i++){
            if(scores[i]==max){
                answer.add(i+1);
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i->i).toArray();
    }
}