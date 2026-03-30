import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(st.nextToken(), 0);
        }

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            while (st.hasMoreTokens()) {
                String student = st.nextToken();
                map.put(student, map.get(student)+1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return Integer.compare(o2.getValue(), o1.getValue());
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.println(sb.toString());
    }
}