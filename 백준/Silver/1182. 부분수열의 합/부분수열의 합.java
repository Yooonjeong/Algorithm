import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, s, cnt=0;
    private static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0, 0);
        System.out.println(cnt);
    }
    private static void solve(int idx, int sum, int size) {
        if (idx == n) {
            if (size > 0 && sum == s) {
                cnt++;
            }
            return;
        }

        solve(idx+1, sum+arr[idx], size+1);
        solve(idx+1, sum, size);
    }
}
