import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int r, c;
    private static boolean[][] map;
    private static Queue<Point> jq = new LinkedList<>();
    private static Queue<Point> fq = new LinkedList<>();
    private static String ans = "IMPOSSIBLE";
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static boolean[][] jVisited;
    private static boolean[][] fVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new boolean[r][c];
        jVisited = new boolean[r][c];
        fVisited = new boolean[r][c];

        for (int i=0; i<r; i++) {
            String in = br.readLine();
            for (int j=0; j<c; j++) {
                char at = in.charAt(j);
                map[i][j] = at == '#' ? false : true;
                if (at == 'J') {
                    jq.add(new Point(i, j));
                    jVisited[i][j] = true;
                }
                else if (at == 'F') {
                    fq.add(new Point(i, j));
                    fVisited[i][j] = true;
                }
            }
        }
        bfs();
        System.out.println(ans);
    }

    private static boolean range(int y, int x) {
        if (y>=0 && y<r && x>=0 && x<c) return true;
        return false;
    }

    private static void bfs() {
        while (!jq.isEmpty()) {
            List<Point> curJ = new ArrayList<>();
            int curDepth = jq.peek().depth;
            while (!jq.isEmpty() && jq.peek().depth == curDepth) {
                curJ.add(jq.poll());
            }

            List<Point> curF = new ArrayList<>();
            while (!fq.isEmpty() && fq.peek().depth == curDepth) {
                curF.add(fq.poll());
            }

            for (Point j : curJ) {
                for (Point f : curF) {
                    if (f.equals(j)) return;
                }
            }

            for (Point f : curF) {
                for (int i=0; i<4; i++) {
                    int nX = f.x + dx[i];
                    int nY = f.y + dy[i];

                    if (range(nY, nX) && !fVisited[nY][nX] && map[nY][nX]) {
                        fVisited[nY][nX] = true;
                        fq.add(new Point(nY, nX, curDepth+1));
                    }
                }
            }

            for (Point j : curJ) {
                for (int i=0; i<4; i++) {
                    int nX = j.x + dx[i];
                    int nY = j.y + dy[i];

                    if (!range(nY, nX)) {
                        ans = String.valueOf(curDepth+1);
                        return;
                    }

                    if (fVisited[nY][nX]) continue;

                    if (!jVisited[nY][nX] && map[nY][nX]) {
                        jVisited[nY][nX] = true;
                        jq.add(new Point(nY, nX, curDepth+1));
                    }
                }
            }   
        }
    }
}

class Point {
    int y;
    int x;
    int depth;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
        this.depth = 0;
    }

    Point(int y, int x, int depth) {
        this.y = y;
        this.x = x;
        this.depth = depth;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return this.y == point.y && this.x == point.x;
    }

    @Override
    public String toString() {
        return "X: "+x+", Y: "+y+", Depth: "+depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}