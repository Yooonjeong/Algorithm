import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] board;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int ans = 0;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            String in = br.readLine();
            for (int j=0; j<m; j++) {
                board[i][j] = in.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(ans);
    }
    private static boolean range(int y, int x) {
        return y>=0 && y<n && x>=0 && x<m;
    }
    private static void bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        queue.add(new int[] {0, 0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == n-1 && cur[1] == m-1) {
                ans =  cur[2];
                return;
            }

            for (int i=0; i<4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (!range(ny, nx) || visited[ny][nx]) continue;

                queue.add(new int[] {ny, nx, cur[2]+board[ny][nx]});
                visited[ny][nx] = true;
            }
        }

    }
}
