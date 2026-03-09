import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name;
        TreeMap<String, Integer> map = new TreeMap<>();

        int all = 0;
        while((name = br.readLine()) != null) {
            map.put(name, map.getOrDefault(name, 0)+1);
            all++;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double ratio = (double) Math.round((double)entry.getValue()/all*100*10000) / 10000;
            String rationStr = String.format("%.4f", ratio);
            sb.append(entry.getKey()).append(" ").append(rationStr).append("\n");
        }

        System.out.println(sb.toString());
    }
}