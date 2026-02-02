import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, k;
    private static char[][] map;
    private static boolean[][][] visited;
    private static int[] dirY = {-1, 0, 1, 0};
    private static int[] dirX = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][k+1];

        for (int i=0; i<n; i++) {
            String in = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = in.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    private static boolean range(int y, int x) {
        return y>=0 && y<n && x>=0 && x<m;
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1, 0});

        int ans = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cnt = cur[2];
            int curK = cur[3];

            if (cur[0] == n-1 && cur[1] == m-1) {
                ans = Math.min(ans, cnt);
                continue;
            }

            for (int i=0; i<4; i++) {
                int nY = cur[0] + dirY[i];
                int nX = cur[1] + dirX[i];

                if (!range(nY, nX)) continue;

                if (map[nY][nX] == '1') {
                    if (curK < k && !visited[nY][nX][curK+1]) {
                        visited[nY][nX][curK+1] = true;
                        queue.add(new int[] {nY, nX, cnt+1, curK+1});
                    }
                }  
                else {
                    if (!visited[nY][nX][curK]) {
                        visited[nY][nX][curK] = true;
                        queue.add(new int[] {nY, nX, cnt+1, curK});
                    }
                }
            }
        }
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}