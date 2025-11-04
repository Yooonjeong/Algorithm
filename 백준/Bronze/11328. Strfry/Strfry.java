import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] arr = st.nextToken().toCharArray();
            map.clear();
            
            for (int j=0; j<arr.length; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
            }

            arr = st.nextToken().toCharArray();
            boolean possible = true;
            for (int j=0; j<arr.length; j++) {
                if (!map.containsKey(arr[j]) || map.get(arr[j]) == 0) {
                    possible = false;
                    break;
                }
                map.put(arr[j], map.get(arr[j])-1);
                if (map.get(arr[j]) == 0) {
                    map.remove(arr[j]);
                }
            }
            if (!possible || map.size() > 0) {
                sb.append("Impossible\n");
            }
            else {
                sb.append("Possible\n");
            }
        }
        System.out.println(sb.toString());
    }
}
