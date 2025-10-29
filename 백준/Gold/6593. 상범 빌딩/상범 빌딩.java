import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static int l, r, c;
    private static char[][][] board;
    private static boolean[][][] visited;
    private static int sZ, sY, sX;
    private static String ans;
    private static int[] dZ = {0, 0, 0, 0, 1, -1};
    private static int[] dY = {0, 0, 1, -1, 0, 0};
    private static int[] dX = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        readInput(br);

        StringBuilder sb = new StringBuilder();

        while(l != 0 && r != 0 && c != 0) {
            for (int i=0; i<l; i++) {
                for (int j=0; j<r; j++) {
                    String in = br.readLine();
                    for (int k=0; k<c; k++) {
                        char at = in.charAt(k);
                        if (at == 'S') {
                            sZ = i;
                            sY = j;
                            sX = k;
                        }
                        board[i][j][k] = in.charAt(k);
                    }
                }
                br.readLine();
            }
            bfs();
            sb.append(ans);
            readInput(br);
        }
        System.out.println(sb.toString());
    }
    
    private static void readInput(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[l][r][c];
        visited = new boolean[l][r][c];
        ans = "Trapped!\n";
    }

    private static boolean range(int z, int y, int x) {
        if (z>=0 && z<l && y>=0 && y<r && x>=0 && x<c) return true;
        return false;
    } 

    private static void bfs() {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {sZ, sY, sX, 0});
        visited[sZ][sY][sX] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (board[cur[0]][cur[1]][cur[2]] == 'E') {
                ans = "Escaped in "+cur[3]+" minute(s).\n";
                return;
            }

            for (int i=0; i<6; i++) {
                int nZ = cur[0] + dZ[i];
                int nY = cur[1] + dY[i];
                int nX = cur[2] + dX[i];

                if (range(nZ, nY, nX) && !visited[nZ][nY][nX] && board[nZ][nY][nX] != '#') {
                    queue.add(new int[]{nZ, nY, nX, cur[3]+1});
                    visited[nZ][nY][nX] = true;
                }
            }
        }
    }
}
