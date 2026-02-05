import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<t; i++) {
            String in = br.readLine();

            sb.append(check(in, 0, 0, in.length()-1)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int check(String str, int cnt, int start, int end) {
        int min = 2;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                cnt++;

                if (cnt > 1) return 2;
                min = Math.min(min, check(str, cnt, start+1, end));
                min = Math.min(min, check(str, cnt, start, end-1));
                return min;
            }
            start++;
            end--;
        }
        
        return cnt == 1 ? 1 : 0;
    }
}