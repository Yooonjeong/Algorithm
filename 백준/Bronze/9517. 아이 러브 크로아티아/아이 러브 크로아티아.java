import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int total = 210;
        int sum = 0;
        int player = k;

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String ans = st.nextToken();
            sum += time;
            if (sb.length() == 0 && sum >= total) {
                sb.append(player == 0 ? 8 : player);
            }
            if (ans.equals("T")) {
                player = (player+1) % 8;
            }
        }
        System.out.println(sb.toString());
    }
}
