import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int s, t;
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
 
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            queue.add(new int[] { s, t });
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (!endTime.isEmpty() && endTime.peek() <= cur[0]) {
                endTime.poll();
            }
            endTime.add(cur[1]);
        }
        System.out.println(endTime.size());
    }
}
