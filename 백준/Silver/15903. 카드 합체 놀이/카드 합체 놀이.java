import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        Long sum = 0L;
        for (int i=0; i<n; i++) {
            Long num = Long.parseLong(st.nextToken());
            sum += num;
            pq.add(num);
        }

        for (int i=0; i<m; i++) {
            Long a = pq.poll();
            Long b = pq.poll();
            sum += a+b;
            pq.add(a+b);
            pq.add(a+b);
        }

        System.out.println(sum);
    }
}