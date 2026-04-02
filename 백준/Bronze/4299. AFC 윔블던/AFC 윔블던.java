import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        if (s < d || (s + d) % 2 != 0) {
            System.out.println(-1);
            return;
        }

        int a = (s + d) / 2;
        int b = (s - d) / 2;

        if (a < 0 || b < 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(a + " " + b);
    }
}