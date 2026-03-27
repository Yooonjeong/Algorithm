import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            String topping = st.nextToken();

            if (topping.endsWith("Cheese")) set.add(topping);
        }

        System.out.println(set.size() >= 4 ? "yummy" : "sad");
    }
}