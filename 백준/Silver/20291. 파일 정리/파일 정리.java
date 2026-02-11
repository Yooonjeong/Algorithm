import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        
        for (int i=0; i<n; i++) {
            String in = br.readLine();
            String extension = in.substring(in.indexOf(".")+1);
            
            map.put(extension, map.getOrDefault(extension, 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()+" "+entry.getValue()).append("\n");
        }

        System.out.println(sb.toString());
    }
}