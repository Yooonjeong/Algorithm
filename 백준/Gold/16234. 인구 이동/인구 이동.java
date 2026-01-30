import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Group {
        int avg;
        int size;

        Group(int avg, int size) {
            this.avg = avg;
            this.size = size;
        }
    }
    private static int n, l, r;
    private static int[][] board;
    private static int[][] visited;
    private static int[] dirY = {-1, 0, 1, 0};
    private static int[] dirX = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        Map<Integer, Integer> map;
        while (true) {
            visited = new int[n][n];
            map = new HashMap<>();
            int cnt=1;
            boolean isOpened = false;

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (visited[i][j] == 0) {
                        Group group = bfs(i, j, cnt);
                        map.put(cnt, group.avg);
                        cnt++;

                        if (!isOpened && group.size > 1) {
                            isOpened = true;
                        }
                    }
                }
            }

            if (!isOpened) {
                System.out.println(day);
                return;
            }
            
            moveAll(map);
            day++;
        }
    }

    private static boolean range(int y, int x) {
        return y>=0 && y<n && x>=0 && x<n;
    }

    private static boolean canOpen(int y1, int x1, int y2, int x2) {
        int diff = Math.abs(board[y1][x1] - board[y2][x2]);
        return l <= diff && diff <= r;
    }

    private static Group bfs(int y, int x, int num) {
        visited[y][x] = num;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});
        int cnt = 1;
        int sum = board[y][x];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for (int i=0; i<4; i++) {
                int nY = curY + dirY[i];
                int nX = curX + dirX[i];

                if (range(nY, nX) && visited[nY][nX] == 0 && canOpen(curY, curX, nY, nX)) {
                    visited[nY][nX] = num;
                    cnt++;
                    sum += board[nY][nX];
                    queue.add(new int[] {nY, nX});
                }
            }
        }

        return new Group(sum / cnt, cnt);
    }

    private static void moveAll(Map<Integer, Integer> map) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = map.get(visited[i][j]);
            }
        }
    }
}
