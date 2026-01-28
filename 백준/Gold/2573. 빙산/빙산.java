import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] board;
    private static int[][] nextBoard;
    private static boolean[][] visited;
    private static int year = 0;
    private static int[] dirY = {-1, 0, 1, 0};
    private static int[] dirX = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        nextBoard = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {

            visited = new boolean[n][m];
            nextBoard = new int[n][m];

            int cnt = 0;
            
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (!visited[i][j] && board[i][j] > 0) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            if (cnt == 0) {
                System.out.println("0");
                return;
            }
            
            if (cnt >= 2) {
                System.out.println(year);
                return;
            }
            
            board = nextBoard;
            year++;
        }
    }

    private static boolean range(int y, int x) {
        return y>=0 && y<n && x>=0 && x<m;
    }

    private static int nextHeight(int y, int x) {
        int cnt = 0;
        for (int i=0; i<4; i++) {
            int nY = y+dirY[i];
            int nX = x+dirX[i];

            if (range(nY, nX) && board[nY][nX] == 0) {
                cnt++;
            }
        }

        return Math.max(board[y][x]-cnt, 0);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});
        visited[y][x] = true;
        nextBoard[y][x] = nextHeight(y, x);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i=0; i<4; i++) {
                int nY = cur[0]+dirY[i];
                int nX = cur[1]+dirX[i];

                if (range(nY, nX) && !visited[nY][nX] && board[nY][nX] > 0) {
                    queue.add(new int[] {nY, nX});
                    visited[nY][nX] = true;
                    nextBoard[nY][nX] = nextHeight(nY, nX);
                }
            }
        }
    }
}
