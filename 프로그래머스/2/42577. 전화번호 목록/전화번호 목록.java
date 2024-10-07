import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
		Map<String, Integer> hash = new HashMap<>();
        
        for(int i=0; i<phone_book.length; i++) {
            hash.put(phone_book[i], i);    
        }
        boolean answer = true;
        for(int i=0; i<phone_book.length; i++){
            for(int j=1; j<phone_book[i].length(); j++){
                if(hash.containsKey(phone_book[i].substring(0,j))) {
                	answer = false;
                	return answer;
                }
            }
        }
        return answer;
    }
}