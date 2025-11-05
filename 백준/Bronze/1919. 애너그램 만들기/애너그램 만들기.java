import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        arr = br.readLine().toCharArray();
        
        int cnt=0;
        for (char c : arr) {
            if (map.containsKey(c)) {
                if (map.get(c) == 0) {
                    map.remove(c);
                    cnt++;
                }
                else map.put(c, map.get(c)-1);
            }
            else cnt++;
        }
        for (int n : map.values()) {
            cnt += n;
        }

        System.out.println(cnt);
    }
}
