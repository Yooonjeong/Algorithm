import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static char[][] arr;
    private static int[] dirY = {0, 1, 0, -1};
    private static int[] dirX = {1, 0, -1, 0};
    private static boolean[][][] visited;
    private static int ans = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m][2];

        for (int i=0; i<n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        bfs();
        System.out.println(ans);
    }
    private static boolean range(int y, int x) {
        return y>=0 && y<n && x>=0 && x<m;
    }
    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1, 0});
        visited[0][0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == n-1 && cur[1] == m-1) {
                ans = cur[2];
                return;
            }

            for (int i=0; i<4; i++) {
                int nY = cur[0]+dirY[i];
                int nX = cur[1]+dirX[i];
                int d = cur[3];

                if (range(nY, nX)) {
                    if (arr[nY][nX] == '0' && !visited[nY][nX][d]) {
                        visited[nY][nX][d] = true;
                        queue.add(new int[] {nY, nX, cur[2]+1, d});
                    }
                    
                    if (arr[nY][nX] == '1' && d == 0 && !visited[nY][nX][d]) {
                        visited[nY][nX][d] = true;
                        queue.add(new int[] {nY, nX, cur[2]+1, 1});
                    }
                }
            }
        }
    }
}
