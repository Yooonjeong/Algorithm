import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> hash = new HashMap<>();
        for(String[] c:clothes){
            hash.put(c[1], hash.getOrDefault(c[1],0)+1);
        }
        int answer = 1;
        Iterator<Entry<String, Integer>> it = hash.entrySet().iterator();
        while(it.hasNext()){
            Entry<String, Integer> entry = it.next();
            answer *= (entry.getValue()+1);
        }
        return answer-1;
    }
}