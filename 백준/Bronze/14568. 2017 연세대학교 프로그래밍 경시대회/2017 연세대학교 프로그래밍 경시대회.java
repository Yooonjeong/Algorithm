import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        // 택희
        for (int A = 2; A <= N - 2; A += 2) {
            // 영훈
            for (int B = 1; B <= N - A - 1; B++) {
                int C = N - A - B; // 남규

                // C 최소 1개 이상, 남규 조건 C >= B + 2
                if (C >= 1 && C >= B + 2) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}