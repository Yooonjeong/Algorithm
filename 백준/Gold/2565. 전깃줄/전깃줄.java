import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Line {
        int a;
        int b;

        Line(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a, b;
        StringTokenizer st;
        Line[] lines = new Line[n];
        

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            lines[i] = new Line(a, b);
        }

        Arrays.sort(lines, (o1, o2) -> Integer.compare(o1.a, o2.a));

        int[] dp = new int[n];
        int max = 0;

        for (int i=0; i<n; i++) {
            dp[i] = 1;

            for (int j=0; j<i; j++) {
                if (lines[j].b < lines[i].b) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(n-max);
    }
}
