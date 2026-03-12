import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long sum = 0;

            int[] arr = new int[n];
            for (int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());

                for (int p=0; p<j; p++) {
                    sum += gcd(arr[j], arr[p]);
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int gcd(int a, int b) {
        int bigger = (a > b) ? a : b;
        int other = (a <= b) ? a : b;

        int r = bigger % other;
        while (r != 0) {
            bigger = other;
            other = r;
            r = bigger % other;
        }

        return other;
    }
}