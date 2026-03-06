import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            long sum = 0;
            int[] arr = new int[n];
            int max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j=n-1; j>=0; j--) {
                max = Math.max(max, arr[j]);

                if (arr[j] < max) {
                    sum += (max - arr[j]);
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}