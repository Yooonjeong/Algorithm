import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        int n = nums.length;
        for(int i=0; i<n; i++){
            hash.put(nums[i], hash.getOrDefault(nums[i], 0)+1);
        }
        int answer = 0;
        if(hash.size()<n/2){
            answer = hash.size();
        }
        else{
            answer = n/2;
        }
        return answer;
    }
}