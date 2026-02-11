import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        
        int[] arr = new int[len*2+1];
        for (int i=0; i<len*2; i++) {
            arr[i] = elements[i%len];
        }
        
        int[] prefix = new int[len*2+1];
        for (int i=0; i<len*2; i++) {
            prefix[i+1] = prefix[i] + arr[i];
        }
        
        for (int i=1; i<=len; i++) {
            for (int start=0; start<len; start++) {
                int sum = prefix[start+i] - prefix[start];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}