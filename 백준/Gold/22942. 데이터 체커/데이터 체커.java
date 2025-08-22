import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int a, b;
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a - b, i, 0});
            pq.add(new int[]{a + b, i, 1});
        }

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[2] == 1) stack.push(cur[1]);
            else if(cur[1] != stack.poll()){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
