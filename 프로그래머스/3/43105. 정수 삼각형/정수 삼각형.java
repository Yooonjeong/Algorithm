import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        Integer dp[][] = new Integer[n][n];
        dp[0][0] = triangle[0][0];
        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][0] + triangle[i][0];
                }
                else if(j==i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+triangle[i][j];
                }
            }
        }
        Arrays.sort(dp[n-1], (a, b) -> b.compareTo(a));
        return dp[n-1][0];
    }
}