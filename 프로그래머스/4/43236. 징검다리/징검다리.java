import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int min = 1;
        int max = distance;
        int mid, cnt, rocMin=0;
        Arrays.sort(rocks);
        int answer = distance;
        while(min<=max){
            cnt=0; rocMin=0;
            mid = (min+max)/2;
            for(int rock:rocks){
                if(rock-rocMin<mid){
                    cnt++;
                }
                else{
                    rocMin = rock;
                }
            }
            if ((distance - rocMin) < mid) {
                cnt++;
            }
            
            if(cnt>n){
                max = mid-1;
            }
            else{
                answer = mid;
                min = mid+1;
            }
        }
        return answer;
    }
}