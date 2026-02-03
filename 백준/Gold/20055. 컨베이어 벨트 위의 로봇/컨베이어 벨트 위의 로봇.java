import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n, k;
    private static List<int[]> list = new LinkedList<>();
    private static int level = 1;
    private static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<2*n; i++) {
            int a = Integer.parseInt(st.nextToken());
            list.add(new int[] {a, 0});
        }
        
        while (true) {
            spinBelt();
            if (spinRobot() || upRobot()) {
                break;
            }
            level++;
        }

        System.out.println(level);
    }

    private static void spinBelt() {
        downRobot();
        list.add(0, list.remove(n*2-1));
    }

    private static boolean spinRobot() {
        downRobot();
        for (int i=n-2; i>=0; i--) {
            int[] cur = list.get(i);
            if (cur[1] > 0) {
                int[] next = list.get(i+1);
                if (next[1] == 0 && next[0] > 0) {
                    cur[1]--;
                    next[1]++;
                    next[0]--;
                    if (next[0] == 0) cnt++;
                }
            }
            if (cnt >= k) return true;
        }
        return false;
    }

    private static boolean upRobot() {
        downRobot();
        int[] first = list.get(0);
        if (first[0] > 0) {
            first[0]--;
            if (first[0] == 0) cnt++;
            first[1]++;
        }
        return cnt >= k;
    }

    private static void downRobot() {
        if (list.get(n-1)[1] > 0) {
            list.get(n-1)[1]--;
        }
    }
}