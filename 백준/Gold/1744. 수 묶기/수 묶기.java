import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static List<Integer> negatives = new ArrayList<>();
    private static List<Integer> positives = new ArrayList<>();
    private static int zero = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            int in = Integer.parseInt(br.readLine());
            if (in < 0) negatives.add(in);
            else if (in == 0) zero++;
            else positives.add(in);
        }
        Collections.sort(negatives);
        Collections.sort(positives, Collections.reverseOrder());

        System.out.println(sum());
    }

    private static int sum() {
        int ans = 0;
        for (int i=0; i+1 < negatives.size(); i += 2) {
            ans += negatives.get(i) * negatives.get(i + 1);
        }
        if (negatives.size() % 2 == 1 && zero == 0) {
            ans += negatives.get(negatives.size()-1);
        }
        if (positives.isEmpty()) return ans;

        int idx = 0;
        while (idx < positives.size()) {
            if (idx+1 < positives.size() && positives.get(idx) > 1 && positives.get(idx+1) > 1) {
                // 두 수가 모두 2 이상이면 곱
                ans += positives.get(idx) * positives.get(idx+1);
                idx += 2;
            } else {
                // 1이 포함된 경우 → 곱하지 말고 그냥 더하기
                ans += positives.get(idx);
                idx++;
            }
        }

        return ans;
    }
}
