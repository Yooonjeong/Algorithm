class Solution {
    public int cnt=0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return cnt;
    }
    public void dfs(int[] numbers, int target, int i, int sum){
        if(i==numbers.length){
            if(sum == target){
                cnt++;
            }
            return;
        }
        sum += numbers[i];
        dfs(numbers, target, i+1, sum);
        sum -= numbers[i]*2;
        dfs(numbers, target, i+1, sum);
    }
}