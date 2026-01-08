import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Cleaner {
        int y;
        int x;

        Cleaner(int y, int x) {
            this.y = y;
            this.x = x;
        }

        void cleanUp() {
            for (int i = y-1; i > 0; i--) board[i][0] = board[i-1][0];

            for (int i = 0; i < c-1; i++) board[0][i] = board[0][i+1];

            for (int i = 0; i < y; i++) board[i][c-1] = board[i+1][c-1];

            for (int i = c-1; i > 1; i--) board[y][i] = board[y][i-1];

            board[y][x + 1] = 0;
        }

        void cleanDown() {
            for (int i = y+1; i < r-1; i++) board[i][0] = board[i+1][0];

            for (int i = 0; i < c-1; i++) board[r-1][i] = board[r-1][i+1];

            for (int i = r-1; i > y; i--) board[i][c-1] = board[i-1][c-1];

            for (int i = c-1; i > 1; i--) board[y][i] = board[y][i-1];
            
            board[y][x + 1] = 0;
        }

        boolean isCleaner(int y, int x) {
            return y == this.y && x == this.x;
        }
    }
    
    private static List<Cleaner> cleaners = new ArrayList<>();
    private static int[][] board;
    private static int r, c, t;
    private static int[] dirY = {-1, 0, 1, 0};
    private static int[] dirX = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        board = new int[r][c];

        for (int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<c; j++) {
                int in = Integer.parseInt(st.nextToken());

                board[i][j] = in;
                if (in == -1) {
                    cleaners.add(new Cleaner(i, j));
                }
            }
        }

        for (int i=0; i<t; i++) {
            spread();
            cleaners.get(0).cleanUp();
            cleaners.get(1).cleanDown();
        }

        System.out.println(sum());
    }

    private static boolean range(int y, int x) {
        return (y>=0 && y<r && x>=0 && x<c && board[y][x] != -1);
    }

    private static void spread() {
        int[][] toAdd = new int[r][c];

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (board[i][j] <= 0) continue;

                int divided = board[i][j]/5;
                int cnt = 0;
                for (int d=0; d<4; d++) {
                    int nY = i + dirY[d];
                    int nX = j + dirX[d];

                    if (range(nY, nX)) {
                        toAdd[nY][nX] += divided;
                        cnt++;
                    }
                }
                board[i][j] -= divided*cnt;
            }
        }

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                board[i][j] += toAdd[i][j];
            }
        }
    }

    private static int sum() {
        int sum = 0;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (board[i][j] <= 0) continue;
                sum += board[i][j];
            }
        }
        return sum;
    }
}
