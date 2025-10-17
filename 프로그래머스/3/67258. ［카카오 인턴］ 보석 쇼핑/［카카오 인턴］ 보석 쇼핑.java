import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int size = set.size();
        Map<String, Integer> map = new HashMap<>();
        map.put(gems[0], 1);
        int[] rst = {1, gems.length};
        
        int start = 0;
        int end = 0;
        while(true) {
            if (map.size() == size) {
                if (end - start < rst[1] - rst[0]) {
                    rst[0] = start+1;
                    rst[1] = end+1;
                }
                int s = map.get(gems[start]);
                if (s <= 1) {
                    map.remove(gems[start]);
                }
                else {
                    map.put(gems[start], s - 1);
                }
                start++;
            }
            else {
                if (end == gems.length - 1) {
                    break;
                }
                
                end++;
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            }
        }
        return rst;
    }
}