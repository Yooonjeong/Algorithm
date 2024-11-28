import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[0], b[0]));
        int left = routes[0][0];
        int right = routes[0][1];
        for(int i=1; i<routes.length; i++){
            int start = routes[i][0];
            if(start>=left && start<=right){
                left = start;
                right = Math.min(right, routes[i][1]);
            }
            else{
                answer++;
                left = routes[i][0];
                right = routes[i][1];
            }
        }
        answer++;
        return answer;
    }
}