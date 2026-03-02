import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, TreeSet<String>> zeroMap = new HashMap<>();
        Map<String, String> oneMap = new HashMap<>();

        for (int i=0; i<n; i++) {
            String team = br.readLine();
            int p = Integer.parseInt(br.readLine());

            TreeSet<String> treeSet = new TreeSet<>();
            for (int j=0; j<p; j++) {
                String member = br.readLine();
                treeSet.add(member);
                oneMap.put(member, team);
            }
            zeroMap.put(team, treeSet);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++) {
            String name = br.readLine();
            int order = Integer.parseInt(br.readLine());
            switch (order) {
                case 0:
                    for (String member : zeroMap.get(name)) {
                        sb.append(member).append("\n");
                    }
                    break;
                case 1:
                    sb.append(oneMap.get(name)).append("\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}