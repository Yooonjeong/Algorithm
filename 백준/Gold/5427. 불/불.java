import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int w, h;
    private static char[][] board;
    private static Queue<int[]> sq = new LinkedList<>();
    private static Queue<int[]> fq = new LinkedList<>();
    private static boolean[][] sVisited;
    private static boolean[][] fVisited;
    private static int[] dirX = {0, 1, 0, -1};
    private static int[] dirY = {-1, 0, 1, 0};
    private static String ans;
    private static List<int[]> curS = new ArrayList<>();
    private static List<int[]> curF = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new char[h][w];
            sVisited = new boolean[h][w];
            fVisited = new boolean[h][w];
            sq.clear();
            fq.clear();

            ans = "IMPOSSIBLE";
            
            for (int j=0; j<h; j++) {
                String in = br.readLine();
                for (int k=0; k<w; k++) {
                    char at = in.charAt(k);
                    if (at == '@') {
                        sq.add(new int[]{j, k, 0});
                        sVisited[j][k] = true;
                    }
                    else if (at == '*') {
                        fq.add(new int[]{j, k, 0});
                        fVisited[j][k] = true;
                    }
                    board[j][k] = at;
                }
            }
            bfs();
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean range(int y, int x) {
        if (y>=0 && y<h && x>=0 && x<w) return true;
        return false;
    }
    
    private static void bfs() {
        int curTime = 0;
        while(!sq.isEmpty()) {

            curS.clear();
            while (!sq.isEmpty() && sq.peek()[2] == curTime) {
                curS.add(sq.poll());
            }

            curF.clear();
            while (!fq.isEmpty() && fq.peek()[2] == curTime) {
                curF.add(fq.poll());
            }

            for (int[] f : curF) {
                for (int i=0; i<4; i++) {
                    int nextY = f[0] + dirY[i];
                    int nextX = f[1] + dirX[i];

                    if (range(nextY, nextX) && board[nextY][nextX] != '#' && !fVisited[nextY][nextX]) {
                        fVisited[nextY][nextX] = true;
                        fq.add(new int[] {nextY, nextX, f[2]+1});
                    }
                }
            }

            for (int[] s : curS) {
                for (int i=0; i<4; i++) {
                    int nextY = s[0] + dirY[i];
                    int nextX = s[1] + dirX[i];

                    if (!range(nextY, nextX)) {
                        ans = String.valueOf(s[2]+1);
                        return;
                    }

                    if (!fVisited[nextY][nextX] && board[nextY][nextX] != '#' && !sVisited[nextY][nextX]) {
                        sVisited[nextY][nextX] = true;
                        sq.add(new int[] {nextY, nextX, s[2]+1});
                    }
                }
            }

            curTime++;
        }
        
    }
}
