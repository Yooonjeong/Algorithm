import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static class Belt {
        int pow;
        boolean robot;

        Belt(int pow) {
            this.pow = pow;
        }

        public boolean existsRobot() {
            return robot;
        }

        public void upRobot() {
            this.robot = true;
            this.pow--;

            if (this.pow == 0) cnt++;
        }

        public void downRobot() {
            this.robot = false;
        }

        public boolean possibleToUp() {
            return !this.robot && this.pow > 0;
        }
    }

    private static int n, k;
    private static List<Belt> list = new ArrayList<>();
    private static int level = 1;
    private static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<2*n; i++) {
            list.add(new Belt(Integer.parseInt(st.nextToken())));
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
            Belt cur = list.get(i);
            if (cur.existsRobot()) {
                Belt next = list.get(i+1);
                if (next.possibleToUp()) {
                    cur.downRobot();
                    next.upRobot();
                }
            }
            if (cnt >= k) return true;
        }
        return false;
    }

    private static boolean upRobot() {
        downRobot();
        Belt first = list.get(0);
        if (first.possibleToUp()) {
            first.upRobot();
        }
        return cnt >= k;
    }

    private static void downRobot() {
        Belt last = list.get(n-1);
        if (last.existsRobot()) {
            last.downRobot();
        }
    }
}