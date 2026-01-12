import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long rst = 1;
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            rst = (rst%m) * (num%m) % m;
        }

        System.out.println(rst);
    }
}
