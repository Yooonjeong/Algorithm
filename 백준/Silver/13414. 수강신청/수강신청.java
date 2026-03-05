import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();
        Set<Integer> toRemove = new HashSet<>();
        Map<String, Integer> idxMap = new HashMap<>();

        for (int i=0; i<l; i++) {
            String identifier = br.readLine();

            if (idxMap.containsKey(identifier)) {
                int prevIdx = idxMap.remove(identifier);
                toRemove.add(prevIdx);
            }

            list.add(identifier);
            idxMap.put(identifier, i);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<list.size(); i++) {
            if (toRemove.contains(i)) continue;

            sb.append(list.get(i)).append("\n");
            cnt++;
            
            if (cnt >= k) break;
        }

        System.out.println(sb.toString());
    }
}