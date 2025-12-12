import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int sum = 0;
        for (int[] a : arr) {
            sum += a[1];
            pq.add(a[1]);
            if (pq.size() > a[0]) {
                sum -= pq.poll();
            }
        }

        System.out.println(sum);
    }
}
