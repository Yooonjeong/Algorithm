import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m, n;
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[n];
            int[] sorted = new int[n];

            for (int j=0; j<n; j++) {
                int size = Integer.parseInt(st.nextToken());
                arr[j] = size;
                sorted[j] = size;
            }

            Arrays.sort(sorted);

            Map<Integer, Integer> rankMap = new HashMap<>();
            int rank = 0;

            for (int j=0; j<n; j++) {
                if (!rankMap.containsKey(sorted[j])) {
                    rankMap.put(sorted[j], rank++);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                sb.append(rankMap.get(arr[j])).append(",");
            }

            String str = sb.toString();
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            sum += (cnt * (cnt-1))/2;
        }

        System.out.println(sum);
    }
}