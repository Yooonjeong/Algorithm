import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m, l;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+2];
        arr[0] = 0;
        arr[n+1] = l;
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 1;
        int right = l;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int need = 0;

            for (int i=1; i<arr.length; i++) {
                need += (arr[i] - arr[i-1] - 1) / mid;
            }

            if (need <= m) {
                answer = mid;
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }

        System.out.println(answer);
    }
}