import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int y;
        int x;
        int n;
        int m;

        Point(int y, int x, int n, int m) {
            this.y = y;
            this.x = x;
            this.n = n;
            this.m = m;
        }

        public void spin() {
            int temp = x;
            this.x = (n-1) - this.y;
            this.y = temp;

            temp = n;
            this.n = m;
            this.m = temp;
        }
    }

    private static int n, m, k;
    private static List<List<Point>> stickers = new ArrayList<>();
    private static boolean[][] visited;
    private static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];

        int r, c;

        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            List<Point> sticker = new ArrayList<>();

            for (int j=0; j<r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l=0; l<c; l++) {
                    int in = Integer.parseInt(st.nextToken());
                    if (in == 1) {
                        sticker.add(new Point(j, l, r, c));
                    }
                }
            }
            stickers.add(sticker);
        }

        outer:
        for (List<Point> sticker : stickers) {
            for (int degree=0; degree<=270; degree+=90) {
                if (degree > 0) {
                    for (Point point : sticker) {
                        point.spin();
                    }
                }
                for (int i=0; i<n; i++) {
                    for (int j=0; j<m; j++) {
                        if (bfs(i, j, sticker)) continue outer;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    private static boolean range(int y, int x) {
        return y>=0 && y<n && x>=0 && x<m;
    }

    private static boolean bfs(int y, int x, List<Point> sticker) {
        for (Point point : sticker) {
            int curY = y+point.y;
            int curX = x+point.x;
            if (!range(curY, curX)) return false;
            if (visited[curY][curX]) {
                return false;
            }
        }
        for (Point point : sticker) {
            visited[y+point.y][x+point.x] = true;
        }
        cnt += sticker.size();
        return true;
    }
}
