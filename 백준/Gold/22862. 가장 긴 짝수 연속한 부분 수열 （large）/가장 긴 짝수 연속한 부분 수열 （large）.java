import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int cnt = 0;
        int max = 0;
        for (int right=0; right<n; right++) {
            if (arr[right] % 2 == 1) cnt++;

            while (cnt > k) {
                cnt -= arr[left++] % 2 == 1 ? 1 : 0;
            }

            max = Math.max(max, right - left + 1 - cnt);
        }

        System.out.println(max);
    }
}