import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, Integer> map;
    private static Set<String> set;
    private static String[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        arr = new String[n];
        map = new HashMap<>();
        set = new HashSet<>();

        for (int i=0; i<n; i++) {
            arr[i] = br.readLine();
            if (set.contains(arr[i])) continue;
            addWord(arr[i]);
            set.add(arr[i]);
        }

        int cnt = 0;
        for (String word : arr) {
            if (!set.contains(word)) continue;
            if (map.getOrDefault(word, 0) == 1) {
                cnt++;
                set.remove(word);
            }
        }
        
        System.out.println(cnt);
    }

    private static void addWord(String word) {
        for(int i=1; i<=word.length(); i++) {
            String subString = word.substring(0, i);
            map.put(subString, map.getOrDefault(subString, 0)+1);
        }
    }
}