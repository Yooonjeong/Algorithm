import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            long count = 0;

            for (int x = 1; x <= a; x++) {
                for (int y = 1; y <= b; y++) {
                    int r1 = x % y;
                    for (int z = 1; z <= c; z++) {
                        int r2 = y % z;
                        if (r1 != r2) continue; // 조금이라도 가지치기
                        int r3 = z % x;
                        if (r1 == r3) {
                            count++;
                        }
                    }
                }
            }

            sb.append(count).append('\n');
        }
        System.out.println(sb.toString());
    }
}
