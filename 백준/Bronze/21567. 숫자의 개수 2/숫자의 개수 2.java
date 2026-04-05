import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long A = Long.parseLong(br.readLine());
        long B = Long.parseLong(br.readLine());
        long C = Long.parseLong(br.readLine());

        long result = A * B * C;
        int[] cnt = new int[10];

        String str = String.valueOf(result);
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(cnt[i]).append('\n');
        }

        System.out.print(sb.toString());
    }
}