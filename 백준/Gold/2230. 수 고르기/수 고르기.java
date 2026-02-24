import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        for (int i=0; i<n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        for (int start=0; start<n; start++) {
            for (int end=start; end<n; end++) {
                long diff =  arr[end] - arr[start];
                if (diff >= m) {
                    min = Math.min(min, diff);
                    break;
                }
            }
        }
        
        System.out.println(min);
    }
}