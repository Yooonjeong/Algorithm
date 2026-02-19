import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for (int end=0; end<n; end++) {
            sum += arr[end];

            while (sum >= s) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }

        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}