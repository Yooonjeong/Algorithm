import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a, b, c, d, e;
        for(int i=0; i<t; i++){
            double sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            sum += a*350.34 + b*230.90 + c*190.55 + d*125.30 + e*180.90;
            sb.append("$").append(String.format("%.2f", sum)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
