import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Line> lines = new ArrayList<>();

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lines.add(new Line(x, y));
        }

        Collections.sort(lines, (a, b) -> a.x - b.x);

        Long ans = 0L;
        int left = lines.get(0).x;
        int right = lines.get(0).y;

        for (int i=1; i<lines.size(); i++) {
            Line line = lines.get(i);
            if (line.isIn(left, right)) {
                left = Math.min(left, line.x);
                right = Math.max(right, line.y);
            }
            else {
                ans += right-left;
                left = line.x;
                right = line.y;
            }
        }
        ans += right-left;

        System.out.println(ans);
    }
}

class Line {
    int x;
    int y;

    Line(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean isIn(int x, int y) {
        if (this.y < x || this.x > y) return false;
        return true;
    }
}