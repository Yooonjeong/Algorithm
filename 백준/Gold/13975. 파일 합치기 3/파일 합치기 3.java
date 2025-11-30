import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        long ans = 0;
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            pq.clear();
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            while(pq.size() > 1) {
                long sum = pq.poll() + pq.poll();
                ans += sum;
                pq.add(sum);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}
