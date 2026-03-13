import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String order = st.nextToken();

        int min = order.equals("Y") ? 1 : order.equals("F") ? 2 : 3;

        Set<String> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            String name = br.readLine();

            set.add(name);
        }

        System.out.println(set.size()/min);
    }
}