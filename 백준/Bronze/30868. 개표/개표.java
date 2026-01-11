import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j=0; j<n/5; j++) {
                sb.append("++++ ");
            }
            for (int j=0; j<n%5; j++) {
                sb.append("|");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
