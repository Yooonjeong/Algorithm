import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] board;
    private static int ans = Integer.MAX_VALUE;
    private static int[] dy = { -1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    private static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int label = 2;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    setIsland(i, j, label);
                    label++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int island = 2; island<label; island++) {
            ans = Math.min(ans, bfs(island));
        }

        System.out.println(ans);
    }
    private static boolean range(int y, int x) {
        return y>=0 && y<n && x>=0 && x<n;
    }
    private static void setIsland(int y, int x, int label) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        board[y][x] = label;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];

                if (range(ny, nx)) {
                    if (board[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        board[ny][nx] = label;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
    private static int bfs(int island) {
        Queue<int[]> start = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == island) {
                    for (int d=0; d<4; d++) {
                        int ny = i+dy[d];
                        int nx = j+dx[d];

                        if (range(ny, nx) && board[ny][nx] == 0 && !visited[ny][nx]) {
                            start.add(new int[] {ny, nx, 1});
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }

        while(!start.isEmpty()) {
            int[] cur = start.poll();

            for (int i=0; i<4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (!range(ny, nx) || visited[ny][nx]) continue;

                if (board[ny][nx] != 0 && board[ny][nx] != island) {
                    return cur[2];
                }

                if (board[ny][nx] == 0) {
                    start.add(new int[] {ny, nx, cur[2]+1});
                    visited[ny][nx] = true;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
