import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static int[] dirX = {0, 1, 0, -1};
    private static int[] dirY = {-1, 0, 1, 0};
    private static int n, m, r, c, d;
    private static boolean[][] visited;
    private static int cnt=0;
    private static boolean stop = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean();

        System.out.println(cnt);
    }

    private static boolean range(int y, int x) {
        return y>=1 && y<n-1 && x>=1 && x<m-1;
    }

    private static void clean() {
        while (true) {
            if (!visited[r][c]) {
                visited[r][c] = true;
                cnt++;
            }
            
            boolean moved = false;

            for (int i=0; i<4; i++) {
                d = (d+3) % 4;
                int ny = r + dirY[d];
                int nx = c + dirX[d];

                if (range(ny, nx) && !visited[ny][nx] && board[ny][nx] == 0) {
                    r = ny;
                    c = nx;
                    moved = true;
                    break;
                }
            }

            if (moved) continue;

            int backD = (d+2) % 4;
            int ny = r + dirY[backD];
            int nx = c + dirX[backD];

            if (!range(ny, nx) || board[ny][nx] == 1) {
                break;
            }

            r = ny;
            c = nx;
        }
    }
}
