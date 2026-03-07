import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();

        Set<String> set = new HashSet<>();
        Set<String> ans = new HashSet<>();

        String line;
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;

            st = new StringTokenizer(line);
            String time = st.nextToken();
            String nickname = st.nextToken();

            if (time.compareTo(q) > 0) continue;

            if (time.compareTo(s) <= 0) {
                set.add(nickname);
            }
            else if (time.compareTo(e) >= 0) {
                if (set.contains(nickname)) ans.add(nickname);
            }
        }

        System.out.println(ans.size());
    }
}