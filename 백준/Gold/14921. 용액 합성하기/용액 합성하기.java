import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n-1;

        long best = Long.MAX_VALUE;

        while (left < right) {
            long sum = (long) arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(best)) {
                best = sum;
            }

            if (sum > 0) right--;
            else left++;
        }

        System.out.println(best);
    }
}