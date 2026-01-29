import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<int[]> houses = new ArrayList<>();
    private static List<int[]> chickens = new ArrayList<>();
    private static boolean[] selected;
    private static int answer = Integer.MAX_VALUE;
    private static int n, m;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    houses.add(new int[] {i, j});
                }
                else if (num == 2) {
                    chickens.add(new int[] {i, j});
                }
            }
        }

        selected = new boolean[chickens.size()];
        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == m) {
            answer = Math.min(answer, calcDistance());
            return;
        }

        if (idx == chickens.size()) return;

        selected[idx] = true;
        dfs(idx + 1, cnt + 1);

        selected[idx] = false;
        dfs(idx + 1, cnt);
    }

    private static int calcDistance() {
        int sum = 0;

        for (int[] house : houses) {
            int minDist = Integer.MAX_VALUE;

            for (int i=0; i<chickens.size(); i++) {
                if (!selected[i]) continue;

                int[] chick = chickens.get(i);
                int dist = Math.abs(house[0] - chick[0]) + Math.abs(house[1] - chick[1]);
                minDist = Math.min(minDist, dist);
            }

            sum += minDist;
        }

        return sum;
    }
}
