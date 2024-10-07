import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();

		for(int i=0; i<participant.length; i++) {
			hash.put(participant[i], hash.getOrDefault(participant[i], 0)+1);
		}
		for(int i=0; i<completion.length; i++) {
			hash.put(completion[i], hash.get(completion[i])-1);
		}
		String answer = "";
		Iterator<Entry<String, Integer>> it = hash.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			if(entry.getValue()!=0) {
				answer = entry.getKey();
				break;
			}
		}
        return answer;
    }
}