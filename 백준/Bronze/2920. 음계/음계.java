import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int prev = Integer.parseInt(st.nextToken());
        boolean asc = true;
        boolean desc = true;

        while (st.hasMoreTokens()) {
            int cur = Integer.parseInt(st.nextToken());

            if (cur != prev + 1) asc = false;
            if (cur != prev - 1) desc = false;

            prev = cur;
        }

        if (asc) System.out.println("ascending");
        else if (desc) System.out.println("descending");
        else System.out.println("mixed");
    }
}
