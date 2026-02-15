import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] arr;
    private static StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i=0; i<n-m+1; i++) {
            backTracking(i, 1, new StringBuilder(arr[i]+" "));
        }

        System.out.println(answer.replace(answer.length()-1, answer.length(), "").toString());
    }

    private static void backTracking(int idx, int cnt, StringBuilder sb) {
        if (idx >= n) return;
        if (cnt >= m) {
            answer.append(sb).append("\n");
            return;
        }

        for (int i=idx+1; i<n; i++) {
            if (arr[idx] < arr[i]) {
                backTracking(i, cnt+1, new StringBuilder(sb).append(arr[i]+" "));
            }
        }
    }
}