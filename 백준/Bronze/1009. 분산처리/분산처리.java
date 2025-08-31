import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int a, b, r;
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            r = 1;

            for (int j=0; j<b; j++){
                r = (r * a) % 10;
            }
            sb.append(r == 0 ? 10 : r).append("\n");
        }
        System.out.println(sb.toString());
    }
}
