import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static class CCTV {
        int y;
        int x;
        int num;

        CCTV(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
        }
    }

    private static class Unit {
        int[][] board;
        int spreaded;

        Unit(int[][] board, int spreaded) {
            this.board = board;
            this.spreaded = spreaded;
        }
    }

    private static List<CCTV> list = new ArrayList<>();
    private static int[] dirY = {0, 1, 0, -1};
    private static int[] dirX = {1, 0, -1, 0};
    private static int n, m;
    private static int min = 0;
    private static int[][][] dirs = {
        {},
        {{0}, {1}, {2}, {3}},
        {{0, 2}, {1, 3}},
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
        {{0, 1, 2, 3}}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (1 <= num && num <= 5) {
                    list.add(new CCTV(i, j, num));
                }
                else if (num == 0) {
                    min++;
                }

                board[i][j] = num;
            }
        }

        if (!list.isEmpty()) {
            look(0, min, board);
        }

        System.out.println(min);
    }

    private static boolean range(int y, int x) {
        return y>=0 && y<n && x>=0 && x<m;
    }

    private static void look(int idx, int cnt, int[][] board) {
        if (idx == list.size()) {
            min = Math.min(min, cnt);
            return;
        }

        CCTV cctv = list.get(idx);

        for (int[] dirs : dirs[cctv.num]) {
            int spreaded = 0;
            int[][] nextBoard = board;

            for (int dir : dirs) {
                Unit unit = spread(cctv, dir, nextBoard);
                nextBoard = unit.board;
                spreaded += unit.spreaded;
            }

            look(idx+1, cnt - spreaded, nextBoard);
        }
    }

    private static Unit spread(CCTV cctv, int idx, int[][] board) {
        int spreaded = 0;
        int ny = cctv.y;
        int nx = cctv.x;
        int[][] copied = deepCopy(board);

        while (true) {
            ny += dirY[idx];
            nx += dirX[idx];

            if (!range(ny, nx)) break;
            if (copied[ny][nx] == 6) break;

            if (copied[ny][nx] == 0) {
                copied[ny][nx] = -1;
                spreaded++;  
            }                  
        }

        return new Unit(copied, spreaded);
    }

    private static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(original[i], m);
        }
        return copy;
    }
}
